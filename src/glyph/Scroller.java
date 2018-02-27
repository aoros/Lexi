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

//    @Override
//    public void setSize(Window window) {
//        super.setSize(window);
//        getGlyph().getBounds().setWidth(getGlyph().getBounds().getWidth() + scrollbarWidth);
//        getGlyph().getBounds().setHeight(getGlyph().getBounds().getHeight());
//    }
//
//    @Override
//    public void setPosition(Cursor cursor) {
//        super.setPosition(cursor);
//        cursor.setX(cursor.getX() + scrollbarWidth);
//    }
    @Override
    public void adjustBoundsAndCursor(Glyph child, Cursor cursor) {
        getGlyph().adjustBoundsAndCursor(child, cursor);
        int wrappedGlyphWidth = child.getBounds().getWidth();

        bounds.setX(super.getGlyph().getBounds().getX());
        bounds.setY(super.getGlyph().getBounds().getY());
        bounds.setWidth(super.getGlyph().getBounds().getWidth() + scrollbarWidth);
        bounds.setHeight(super.getGlyph().getBounds().getHeight());

//        if (areGlyphsInColumn(cursor)) {
//            maxWidth = wrappedGlyphWidth > maxWidth ? wrappedGlyphWidth : maxWidth;
//        } else {
//            maxWidth += wrappedGlyphWidth;
//        }
//        super.getBounds().setWidth(maxWidth + scrollbarWidth);
    }

    private boolean areGlyphsInColumn(Cursor cursor) {
        return super.getBounds().getX() == cursor.getX();
    }

    @Override
    public void draw(Window window) {
        super.draw(window);

        int x = getGlyph().getBounds().getX() + getGlyph().getBounds().getWidth() + scrollbarWidth;
        int y = getGlyph().getBounds().getY();
        int w = scrollbarWidth;
        int h = getGlyph().getBounds().getHeight();

        window.addScrollBar(x, y, w, h);
    }
}
