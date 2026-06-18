// Demonstrates the website-monitoring system using the Observer pattern.
public class Main {

    public static void main(String[] args) {

        // --- Setup ---
        MonitoringSystem system = new MonitoringSystem();

        User alice = new User(1, "Alice", "alice@example.com");
        User bob   = new User(2, "Bob",   "bob@example.com");
        system.addUser(alice);
        system.addUser(bob);

        Website amazon = new Website("Amazon.com");
        Website BBC = new Website("BBC.com");
        system.addWebsite(amazon);
        system.addWebsite(BBC);

        // Register website subscriptions (each subscription becomes an Observer of the Website)
        alice.register(amazon, FREQUENCY.DAILY, "SMS");
        bob.register(amazon, FREQUENCY.DAILY, "email");
        bob.register(BBC, FREQUENCY.MONTHLY, "SMS");

        // Update frequency
        bob.manageSubscriptions().get(1).update(FREQUENCY.DAILY);

        // Update website amazon — observers are notified automatically
        System.out.println("\n--- Updating Amazon content ---");
        amazon.updateContent("The sales is on July 28th");

        // Update website BBC — observers are notified automatically
        System.out.println("\n--- Updating BBC content ---");
        BBC.updateContent("Breaking news: new discovery");
    }
}
