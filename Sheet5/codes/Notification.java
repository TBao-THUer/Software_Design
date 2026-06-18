// Represents a single notification message sent to a user.
public class Notification {

    private int notificationId;
    private String message;

    public Notification(int notificationId, String message) {
        this.notificationId = notificationId;
        this.message = message;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    // Generates the notification content.
    public void generate(String websiteUrl) {
        this.message = "Update detected on: " + websiteUrl;
        System.out.println("Notification " + notificationId + " generated.");
    }

    // Sends the notification via the configured channel.
    public void send(String channel, String recipient) {
        System.out.println("Sending [" + message + "] to " + recipient
                + " via " + channel);
    }

    @Override
    public String toString() {
        return "Notification{id='" + notificationId
                + "', message='" + message + "'}";
    }
}
