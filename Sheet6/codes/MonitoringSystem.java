import java.util.*;

/**
 * Central controller for the website-monitoring system.
 * Manages users and websites. With the Observer pattern,
 * notifications are triggered automatically when a Website's
 * content changes — no manual polling needed.
 */
public class MonitoringSystem {

    private List<User> listUsers;
    private List<Website> listWeb;

    public MonitoringSystem() {
        this.listUsers = new ArrayList<>();
        this.listWeb = new ArrayList<>();
    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public List<Website> getListWeb() {
        return listWeb;
    }

    /** Registers a user with the system. */
    public void addUser(User user) {
        listUsers.add(user);
        System.out.println("User registered: " + user);
    }

    /** Registers a website with the system. */
    public void addWebsite(Website website) {
        listWeb.add(website);
        System.out.println("Website added: " + website);
    }
}
