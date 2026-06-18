// Subject interface for the Observer pattern.
// Any class that can be observed implements this.
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
