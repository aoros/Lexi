// Composite(163).Composite
package glyph;

import compositor.Cursor;
import window.Window;

public class Row extends CompositeGlyph {

    public Row(Window window) {
        super(window);
    }

    public Row(String string, Window window) {
        super(window);
        try {
            for (int i = 0; i < string.length(); i++) {
                super.insert(new Character(string.charAt(i)), i);
            }
        } catch (GlyphException e) {
            System.out.println(e);
        }
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    @Override
    public void setSize(Window window) {
    }

    @Override
    public void setPosition(Cursor cursor) {
        bounds.setX(cursor.getX());
        bounds.setY(cursor.getY());
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        int childHeight = glyph.getBounds().getHeight();
        bounds.setHeight(bounds.getHeight() > childHeight ? bounds.getHeight() : childHeight);
        bounds.setWidth(cursor.getX() + glyph.getBounds().getWidth());
        if (cursor.getX() == glyph.getBounds().getX())
            cursor.setX(bounds.getWidth());
        else
            cursor.setX(bounds.getX() + bounds.getWidth());
        cursor.setY(bounds.getY());
    }

    @Override
    public String toString() {
        return "Row{" + "bounds=" + bounds + '}';
    }
}
