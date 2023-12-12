import java.io.*;
import java.net.*;

public class UdpServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876)) {
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData());
                ObjectInputStream objectStream = new ObjectInputStream(byteStream);

                Message receivedMessage = (Message) objectStream.readObject();
                System.out.println("Received message:");
                System.out.println("Date: " + receivedMessage.getHeader().getDate());
                System.out.println("Time: " + receivedMessage.getHeader().getTime());
                System.out.println("Status: " + receivedMessage.getHeader().getStatus());
                System.out.println("Messages: " + String.join(", ", receivedMessage.getBody().getMessages()));

                // Log the message and send back acknowledgment
                receivedMessage.getHeader().setStatus("received");
                ByteArrayOutputStream responseByteStream = new ByteArrayOutputStream();
                ObjectOutputStream responseObjectStream = new ObjectOutputStream(responseByteStream);
                responseObjectStream.writeObject(receivedMessage);

                byte[] responseBuffer = responseByteStream.toByteArray();
                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length,
                        packet.getAddress(), packet.getPort());

                socket.send(responsePacket);

                System.out.println("Acknowledgment sent back to client.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}