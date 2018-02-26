package glyph;

import compositor.Cursor;
import window.Window;

public class Scroller extends Embellishment {

    private static final int DEFAULT_PADDING = 5;
    private int scrollbarWidth = 10;
    private int maxWidth;

    public Scroller(Composition composition) {
        super(composition, DEFAULT_PADDING);
    }

    public Scroller(Composition composition, int scrollbarWidth) {
        super(composition, DEFAULT_PADDING);
        this.scrollbarWidth = scrollbarWidth;
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        super.adjustBoundsAndCursor(glyph, cursor);
        int glyphWidth = glyph.getBounds().getWidth();

        if (areGlyphsInColumn(cursor)) {
            maxWidth = glyphWidth > maxWidth ? glyphWidth : maxWidth;
        } else {
            maxWidth += glyphWidth;
        }
        super.getBounds().setWidth(maxWidth + scrollbarWidth);
    }

    private boolean areGlyphsInColumn(Cursor cursor) {
        return super.getBounds().getX() == cursor.getX();
    }

    @Override
    public void draw(Window window) {
        super.draw(window);

        int x = super.getBounds().getX() + super.getBounds().getWidth() - scrollbarWidth - padding;
        int y = super.getBounds().getY() + padding;
        int w = scrollbarWidth;
        int h = super.getBounds().getHeight() - padding*2;

        window.addScrollBar(x, y, w, h);
    }

    @Override
    public void compose() {
        compositor.compose();
    }
}
