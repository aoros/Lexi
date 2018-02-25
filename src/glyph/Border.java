package glyph;

import compositor.Cursor;
import window.Window;

public class Border extends Embellishment {

    private int thickness = 5;
    private int maxHeight;
    private int maxWidth;

    public Border(Composition composition) {
        super(composition);
    }

    public Border(Composition composition, int thickness) {
        super(composition);
        this.thickness = thickness;
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
            super.getBounds().setWidth(maxWidth + thickness * 2);
            super.getBounds().setHeight(superHeight + thickness * 2);
        } else {
            maxHeight = glyphHeight > maxHeight ? glyphHeight : maxHeight;
            super.getBounds().setHeight(maxHeight + thickness * 2);
            super.getBounds().setWidth(superWidth + thickness * 2);
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

        window.addBorder(x1, y1, x2, y2, thickness);
    }

    @Override
    public void compose() {
        compositor.compose();
    }

    private boolean areGlyphsInColumn(Cursor cursor) {
        return super.getBounds().getX() == cursor.getX();
    }

    private void shiftGlyphAndAllChildren(Glyph glyph) {
        glyph.getBounds().setX(glyph.getBounds().getX() + thickness);
        glyph.getBounds().setY(glyph.getBounds().getY() + thickness);
        int i = 0;
        while (true) {
            try {
                Glyph child = glyph.getChild(i);
                child.getBounds().setX(child.getBounds().getX() + thickness);
                child.getBounds().setY(child.getBounds().getY() + thickness);
                i++;
            } catch (Exception ex) {
                break;
            }
        }
    }
}
