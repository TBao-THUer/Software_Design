import java.util.*;

/**
 * A monitored website. Acts as the <b>Subject</b> in the Observer pattern and
 * as the <b>Context</b> in the Strategy pattern: it delegates change-detection
 * to a {@link ComparisonStrategy} that can be swapped at runtime.
 */
public class Website implements Subject {

    private String urlWebsite;
    private String currentContent;
    private String cachedContent;
    private List<Observer> observers;
    private ComparisonStrategy comparisonStrategy;

    public Website(String urlWebsite) {
        this(urlWebsite, new HtmlContentComparison()); // sensible default
    }

    public Website(String urlWebsite, ComparisonStrategy comparisonStrategy) {
        this.urlWebsite = urlWebsite;
        this.cachedContent = "";
        this.currentContent = "";
        this.observers = new ArrayList<>();
        this.comparisonStrategy = comparisonStrategy;
    }

    public String getUrlWebsite() {
        return this.urlWebsite;
    }

    /** Swaps the comparison strategy used to detect content changes. */
    public void setComparisonStrategy(ComparisonStrategy comparisonStrategy) {
        this.comparisonStrategy = comparisonStrategy;
        System.out.println(urlWebsite + " now using strategy: "
                + comparisonStrategy.getName());
    }

    public ComparisonStrategy getComparisonStrategy() {
        return comparisonStrategy;
    }

    /**
     * Updates content and notifies observers only when the current comparison
     * strategy reports that the content is no longer identical to the cache.
     */
    public void updateContent(String contentUpdated) {
        this.currentContent = contentUpdated;
        if (!comparisonStrategy.isIdentical(cachedContent, currentContent)) {
            notifyObservers();
            this.cachedContent = currentContent; // sync cache after notifying
        } else {
            System.out.println("No change detected by '"
                    + comparisonStrategy.getName() + "' — observers not notified.");
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
