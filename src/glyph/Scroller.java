package glyph;

import compositor.Cursor;
import window.Window;

public class Scroller extends Embellishment {

    private int thickness = 10;
    private int maxWidth;

    public Scroller(Composition composition) {
        super(composition);
    }

    public Scroller(Composition composition, int thickness) {
        super(composition);
        this.thickness = thickness;
    }

    @Override
    public void compose() {
        compositor.compose();
    }

    @Override
    public void draw(Window window) {
        super.draw(window);

        int x = super.getBounds().getX() + super.getBounds().getWidth() - thickness;
        int y = super.getBounds().getY();
        int w = thickness;
        int h = super.getBounds().getHeight();

        window.addScrollBar(x, y, w, h);
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        super.adjustBoundsAndCursor(glyph, cursor);
        int glyphWidth = glyph.getBounds().getWidth();
        if (super.getBounds().getX() == cursor.getX()) {
            maxWidth = glyphWidth > maxWidth ? glyphWidth : maxWidth;
            super.getBounds().setWidth(maxWidth + thickness);
        } else {
            maxWidth += glyphWidth;
            super.getBounds().setWidth(maxWidth + thickness);
        }
    }
}
