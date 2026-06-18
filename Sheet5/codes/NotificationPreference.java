enum FREQUENCY {
    DAILY,
    MONTHLY,
    YEARLY,
}

// Stores how and how often a user wants to be notified.
public class NotificationPreference {

    private int preferenceId;
    private FREQUENCY frequency; // e.g. "daily", "weekly"
    private String channel; // e.g. "email", "sms"

    public NotificationPreference(int preferenceId, FREQUENCY frequency, String channel) {
        this.preferenceId = preferenceId;
        this.frequency = frequency;
        this.channel = channel;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public FREQUENCY getFrequency() {
        return frequency;
    }

    public String getChannel() {
        return channel;
    }

    // Updates the notification preference settings.
    public void updatePreference(FREQUENCY frequency, String channel) {
        this.frequency = frequency;
        this.channel = channel;
        System.out.println("Preference " + preferenceId + " updated: "
                + frequency + " via " + channel);
    }

    @Override
    public String toString() {
        return "NotificationPreference{id='" + preferenceId
                + "', frequency='" + frequency
                + "', channel='" + channel + "'}";
    }
}
