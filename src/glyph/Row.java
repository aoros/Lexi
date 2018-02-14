package glyph;

import compositor.Cursor;
import window.Window;

public class Row extends CompositeGlyph {

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
        int childHeight = glyph.getBounds().getHeight();

        height = height > childHeight ? height : childHeight;
        width = cursor.getX() + glyph.getBounds().getWidth();
        cursor.setX(x + width);
        cursor.setY(y);
    }

    @Override
    public String toString() {
        return "Row{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + '}';
    }
}
