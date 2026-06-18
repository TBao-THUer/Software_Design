/**
 * Comparison strategy based on the visible <b>text</b> content.
 *
 * <p>HTML tags are stripped from both versions and the remaining text is
 * normalised (collapsed whitespace, trimmed) before comparison. Two versions
 * are considered identical when their plain text is equal, so purely structural
 * HTML changes that do not alter the visible text are ignored.</p>
 */
public class TextContentComparison implements ComparisonStrategy {

    @Override
    public boolean isIdentical(String oldContent, String newContent) {
        return extractText(oldContent).equals(extractText(newContent));
    }

    @Override
    public String getName() {
        return "Identical text content";
    }

    /** Removes HTML tags and normalises whitespace to obtain plain text. */
    private String extractText(String html) {
        return html.replaceAll("<[^>]*>", " ") // drop tags
                   .replaceAll("\\s+", " ")     // collapse whitespace
                   .trim();
    }
}
