import java.util.*;

// A registered user of the monitoring system.
public class User {

    private int userId;
    private String name;
    private String email;
    private List<Subscription> subscriptions;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Subscription> manageSubscriptions() {
        return subscriptions;
    }

    // Registers a new subscription for the given website URL.
    public void register(Website web, FREQUENCY frequency, String channel) {
        NotificationPreference notifyPre = new NotificationPreference((int)this.subscriptions.size(), frequency, channel);
        Subscription sub = new Subscription(this, (int)this.subscriptions.size(), frequency, notifyPre);
        sub.create(web);
        this.subscriptions.add(sub);
        System.out.println("User " + name + " registering for: " + web.getUrlWebsite());
    }

    @Override
    public String toString() {
        return "User{userId=" + userId
                + ", name='" + name
                + "', email='" + email + "'}";
    }
}
