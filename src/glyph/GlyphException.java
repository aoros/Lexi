package glyph;

public class GlyphException extends Exception {

    public GlyphException(Exception ex) {
        super(ex);
    }

    public GlyphException(String message) {
        super(message);
    }
}
