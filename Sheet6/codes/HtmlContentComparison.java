/**
 * Comparison strategy based on the full <b>HTML</b> content.
 *
 * <p>Two versions are considered identical only when their raw HTML strings
 * match exactly. Any difference — including changes inside tags or attributes —
 * is treated as a change.</p>
 */
public class HtmlContentComparison implements ComparisonStrategy {

    @Override
    public boolean isIdentical(String oldContent, String newContent) {
        return oldContent.equals(newContent);
    }

    @Override
    public String getName() {
        return "Identical HTML content";
    }
}
