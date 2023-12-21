public 
class MessageHeader implements Serializable {
    private final String date;
    private final String time;
    private final String status;

    public MessageHeader(String date, String time, String status) {
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}