package glyph;

import compositor.Cursor;
import window.Window;

public class Scroller extends Embellishment {

    private int scrollbarWidth = 10;
    private int maxWidth;

    public Scroller(Glyph glyph) {
        super(glyph);
    }

    public Scroller(Glyph glyph, int scrollbarWidth) {
        super(glyph);
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

        int x = super.getBounds().getX() + super.getBounds().getWidth() - scrollbarWidth;
        int y = super.getBounds().getY();
        int w = scrollbarWidth;
        int h = super.getBounds().getHeight();

        window.addScrollBar(x, y, w, h);
    }
}
