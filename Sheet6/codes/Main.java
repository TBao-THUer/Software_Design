/**
 * Demonstrates the website-monitoring system using the Observer pattern
 * combined with the Strategy pattern for content comparison.
 *
 * Each website uses a {@link ComparisonStrategy} that decides whether a content
 * update counts as a "change" and therefore triggers observer notifications.
 */
public class Main {

    public static void main(String[] args) {

        // --- Setup ---
        MonitoringSystem system = new MonitoringSystem();

        User alice = new User(1, "Alice", "alice@example.com");
        User bob   = new User(2, "Bob",   "bob@example.com");
        system.addUser(alice);
        system.addUser(bob);

        Website amazon = new Website("Amazon.com");
        Website bbc    = new Website("BBC.com");
        Website wiki   = new Website("Wikipedia.org");
        system.addWebsite(amazon);
        system.addWebsite(bbc);
        system.addWebsite(wiki);

        // Each subscription becomes an Observer of its Website.
        alice.register(amazon, FREQUENCY.DAILY, "SMS");
        bob.register(bbc, FREQUENCY.MONTHLY, "email");
        alice.register(wiki, FREQUENCY.DAILY, "email");

        // ---------------------------------------------------------------
        // Strategy 1: Identical content SIZE
        // A change is reported only when the content length differs.
        // ---------------------------------------------------------------
        System.out.println("\n===== Strategy 1: Identical content size (Amazon) =====");
        amazon.setComparisonStrategy(new ContentSizeComparison());

        amazon.updateContent("12345");           // length 0 -> 5 : CHANGE -> notify
        amazon.updateContent("ABCDE");           // length 5 -> 5 : SAME  -> no notify
        amazon.updateContent("Longer content");  // length 5 -> 14: CHANGE -> notify

        // ---------------------------------------------------------------
        // Strategy 2: Identical HTML content
        // Any difference in the raw HTML is reported as a change.
        // ---------------------------------------------------------------
        System.out.println("\n===== Strategy 2: Identical HTML content (BBC) =====");
        bbc.setComparisonStrategy(new HtmlContentComparison());

        bbc.updateContent("<h1>News</h1>");          // CHANGE -> notify
        bbc.updateContent("<h1>News</h1>");          // SAME   -> no notify
        bbc.updateContent("<h1>Breaking News</h1>"); // CHANGE -> notify

        // ---------------------------------------------------------------
        // Strategy 3: Identical TEXT content
        // Only changes to the visible text count; pure markup changes are ignored.
        // ---------------------------------------------------------------
        System.out.println("\n===== Strategy 3: Identical text content (Wikipedia) =====");
        wiki.setComparisonStrategy(new TextContentComparison());

        wiki.updateContent("<p>Hello world</p>");            // CHANGE -> notify
        wiki.updateContent("<div><b>Hello world</b></div>"); // same TEXT -> no notify
        wiki.updateContent("<p>Hello universe</p>");         // text changed -> notify
    }
}
