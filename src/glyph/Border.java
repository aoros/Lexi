package glyph;

import compositor.Cursor;
import window.Window;

public class Border extends Embellishment {

    private int padding = 5;
    private int maxHeight;
    private int maxWidth;

    public Border(Glyph glyph) {
        super(glyph);
    }

    public Border(Glyph glyph, int padding) {
        super(glyph);
		this.padding = padding;
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        super.adjustBoundsAndCursor(glyph, cursor);
        int glyphWidth = glyph.getBounds().getWidth();
        int glyphHeight = glyph.getBounds().getHeight();
        int superWidth = super.getBounds().getWidth();
        int superHeight = super.getBounds().getHeight();

        if (areGlyphsInColumn(cursor)) {
            maxWidth = glyphWidth > maxWidth ? glyphWidth : maxWidth;
            super.getBounds().setWidth(maxWidth + padding * 2);
            super.getBounds().setHeight(superHeight + padding * 2);
        } else {
            maxHeight = glyphHeight > maxHeight ? glyphHeight : maxHeight;
            super.getBounds().setHeight(maxHeight + padding * 2);
            super.getBounds().setWidth(superWidth + padding * 2);
        }
        shiftGlyphAndAllChildren(glyph);
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
        int x1 = super.getBounds().getX();
        int y1 = super.getBounds().getY();
        int x2 = super.getBounds().getX() + super.getBounds().getWidth();
        int y2 = super.getBounds().getY() + super.getBounds().getHeight();

        window.addBorder(x1, y1, x2, y2, padding);
    }

    private boolean areGlyphsInColumn(Cursor cursor) {
        return super.getBounds().getX() == cursor.getX();
    }

    private void shiftGlyphAndAllChildren(Glyph glyph) {
        glyph.getBounds().setX(glyph.getBounds().getX() + padding);
        glyph.getBounds().setY(glyph.getBounds().getY() + padding);
        int i = 0;
        while (true) {
            try {
                Glyph child = glyph.getChild(i);
                child.getBounds().setX(child.getBounds().getX() + padding);
                child.getBounds().setY(child.getBounds().getY() + padding);
                i++;
            } catch (Exception ex) {
                break;
            }
        }
    }
}
