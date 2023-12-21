public class MessageBody implements Serializable {
    private final String[] messages;
    private final String status;

    public MessageBody(String[] messages, String status) {
        this.messages = messages;
        this.status = status;
    }

    public String[] getMessages() {
        return messages;
    }

    public String getStatus() {
        return status;
    }
}