/**
 * Comparison strategy based on the <b>size</b> of the content.
 *
 * <p>Two versions are considered identical when they contain the same number
 * of characters. A change is detected only when the content length differs.</p>
 */
public class ContentSizeComparison implements ComparisonStrategy {

    @Override
    public boolean isIdentical(String oldContent, String newContent) {
        return oldContent.length() == newContent.length();
    }

    @Override
    public String getName() {
        return "Identical content size";
    }
}
