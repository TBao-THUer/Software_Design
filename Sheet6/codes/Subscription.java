import java.util.*;

/**
 * A subscription links a user to a website and holds
 * the associated preferences and notifications.
 * Implements Observer to react to Website content changes.
 */
public class Subscription implements Observer {

    private User owner;
    private int subscriptionId;
    private FREQUENCY frequency;
    private SubscriptionStatus status;

    private Website website;
    private NotificationPreference notificationPreference;
    private List<Notification> notifications;

    public Subscription(User owner, int subscriptionId, FREQUENCY frequency,
            NotificationPreference preference) {
        this.owner = owner;
        this.subscriptionId = subscriptionId;
        this.frequency = frequency;
        this.status = SubscriptionStatus.ACTIVE;
        this.notificationPreference = preference;
        this.notifications = new ArrayList<>();
    }

    public String getOwnerName() {
        return this.owner.getName();
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public FREQUENCY getFrequency() {
        return frequency;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public Website getWebsite() {
        return website;
    }

    public NotificationPreference getPreference() {
        return notificationPreference;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    // Creates (activates) the subscription and registers as an observer of the website.
    public void create(Website web) {
        this.website = web;
        this.status = SubscriptionStatus.ACTIVE;
        web.addObserver(this); // Register as observer
        System.out.println("Subscription " + subscriptionId
                + " created for " + web.getUrlWebsite());
    }

    // Called automatically by the Website (Subject) when its content changes.
    @Override
    public void update(Website website) {
        if (this.status == SubscriptionStatus.ACTIVE) {
            String mess = "The Website with " + website.getUrlWebsite() + " is updated";
            Notification notif = new Notification(notifications.size(), mess);
            notif.generate(website.getUrlWebsite());
            addNotification(notif);
        }
    }

    // Updates the subscription frequency.
    public void update(FREQUENCY newFrequency) {
        this.frequency = newFrequency;
        System.out.println("Subscription " + subscriptionId
                + " for " + this.website.getUrlWebsite() + " updated to frequency: " + newFrequency);
    }

    // Cancels this subscription and unregisters from the website.
    public void cancel() {
        this.status = SubscriptionStatus.CANCELLED;
        if (this.website != null) {
            this.website.removeObserver(this); // Unregister as observer
        }
        System.out.println("Subscription " + subscriptionId + " cancelled.");
    }

    // Adds a notification to this subscription's history.
    public void addNotification(Notification notification) {
        notifications.add(notification);
        notification.send(this.notificationPreference.getChannel(), this.owner.getName());
    }

    @Override
    public String toString() {
        return "Subscription{id='" + subscriptionId
                + "', frequency='" + frequency
                + "', status='" + status + "'}";
    }
}
