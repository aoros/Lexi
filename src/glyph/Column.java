// Composite(163).Composite
package glyph;

import compositor.Cursor;
import window.Window;

public class Column extends CompositeGlyph {

    int x;
    int y;
    int width;
    int height;

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, width, height);
    }

    @Override
    public void setSize(Window window) {
    }

    @Override
    public void setPosition(Cursor cursor) {
        x = cursor.getX();
        y = cursor.getY();
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        int childWidth = glyph.getBounds().getWidth();

        height = cursor.getY() + glyph.getBounds().getHeight();
        width = width > childWidth ? width : childWidth;
        cursor.setX(x);
        cursor.setY(y + height);
    }

    @Override
    public String toString() {
        return "Column{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + '}';
    }
    
}
