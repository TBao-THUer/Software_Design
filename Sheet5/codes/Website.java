import java.util.*;

public class Website implements Subject {

    private String urlWebsite;
    private String currentContent;
    private String cachedContent;
    private List<Observer> observers;

    public Website(String urlWebsite) {
        this.urlWebsite = urlWebsite;
        this.cachedContent = "";
        this.currentContent = "";
        this.observers = new ArrayList<>();
    }

    public String getUrlWebsite() {
        return this.urlWebsite;
    }

    // Updates content and automatically notifies all observers if content changed.
    public void updateContent(String contentUpdated) {
        this.currentContent = contentUpdated;
        if (!currentContent.equals(cachedContent)) {
            notifyObservers();
            this.cachedContent = currentContent; // sync cache after notifying
        }
    }

    public String fetchContent() {
        return this.currentContent;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Website{urlWebsite='" + urlWebsite + "'}";
    }
}
