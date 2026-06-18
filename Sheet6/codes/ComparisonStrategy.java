/**
 * Strategy interface for comparing two versions of a website's content.
 *
 * <p>Each concrete strategy decides what "identical" means. The {@link Website}
 * (context) delegates change-detection to whichever strategy is currently set,
 * so the rule for deciding whether observers are notified can be swapped at
 * runtime without modifying the Website class.</p>
 */
public interface ComparisonStrategy {

    /**
     * Returns {@code true} when the two contents are considered identical
     * under this strategy's rule. When they are not identical, the Website
     * treats it as a change and notifies its observers.
     *
     * @param oldContent the previously cached content
     * @param newContent the newly fetched content
     * @return {@code true} if the contents are identical, {@code false} otherwise
     */
    boolean isIdentical(String oldContent, String newContent);

    /** @return a short human-readable name of this strategy (for logging). */
    String getName();
}
