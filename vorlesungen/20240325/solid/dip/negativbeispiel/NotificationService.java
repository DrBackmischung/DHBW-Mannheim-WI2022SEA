class NotificationService {
    private EmailNotification emailNotification;

    public NotificationService() {
        this.emailNotification = new EmailNotification();
    }

    public void sendNotification(String message) {
        // Abhängigkeit von einer konkreten Implementierung
        emailNotification.sendEmail(message);
    }
}