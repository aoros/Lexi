// Composite(163).Composite
package glyph;

import compositor.Cursor;
import window.Window;

public class Column extends CompositeGlyph {

    public Column(Window window) {
        super(window);
    }

    public Column(String[] strings, Window window) {
        super(window);
        try {
            for (int i = 0; i < strings.length; i++) {
                super.insert(new Row(strings[i], window), i);
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
        int childWidth = glyph.getBounds().getWidth();

        bounds.setHeight(cursor.getY() + glyph.getBounds().getHeight());
        bounds.setWidth(bounds.getWidth() > childWidth ? bounds.getWidth() : childWidth);
        cursor.setX(bounds.getX());
        if (cursor.getY() == bounds.getY())
            cursor.setY(bounds.getHeight());
        else
            cursor.setY(bounds.getY() + bounds.getHeight());
    }

    @Override
    public String toString() {
        return "Column{" + "bounds=" + bounds + '}';
    }
}
