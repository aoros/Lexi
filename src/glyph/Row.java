// Composite(163).Composite
package glyph;

import compositor.Cursor;
import window.Window;

public class Row extends CompositeGlyph {

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
        cursor.setX(bounds.getX() + bounds.getWidth());
        cursor.setY(bounds.getY());
    }

    @Override
    public String toString() {
        return "Row{" + "bounds=" + bounds + '}';
    }
}
