import java.io.*;
import java.net.*;

public class Message implements Serializable {
    private final MessageHeader header;
    private final MessageBody body;

    public Message(MessageHeader header, MessageBody body) {
        this.header = header;
        this.body = body;
    }

    public MessageHeader getHeader() {
        return header;
    }

    public MessageBody getBody() {
        return body;
    }
}