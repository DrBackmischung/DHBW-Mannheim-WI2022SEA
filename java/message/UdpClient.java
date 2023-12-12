import java.io.*;
import java.net.*;

public class UdpClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            String[] messages = {"Message 1", "Message 2", "Message 3"};

            MessageHeader header = new MessageHeader("2023-12-10", "12:34:56", "sent");
            MessageBody body = new MessageBody(messages, "pending");

            Message message = new Message(header, body);

            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(message);

            byte[] buffer = byteStream.toByteArray();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            socket.send(packet);

            System.out.println("Message sent to server.");

            // Receive acknowledgment from the server
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);

            ByteArrayInputStream responseByteStream = new ByteArrayInputStream(responsePacket.getData());
            ObjectInputStream responseObjectStream = new ObjectInputStream(responseByteStream);

            Message acknowledgment = (Message) responseObjectStream.readObject();
            System.out.println("Acknowledgment received:");
            System.out.println("Date: " + acknowledgment.getHeader().getDate());
            System.out.println("Time: " + acknowledgment.getHeader().getTime());
            System.out.println("Status: " + acknowledgment.getHeader().getStatus());
            System.out.println("Messages: " + String.join(", ", acknowledgment.getBody().getMessages()));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}