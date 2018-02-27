// Composite(163).Composite
package glyph;

import compositor.Cursor;
import window.Window;

public class Column extends CompositeGlyph {

    public Column(Window window) {
        super(window);
    }

    public Column(Window window, String name) {
        super(window);
        super.name = name;
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

    public Column(String[] strings, Window window, String name) {
        this(strings, window);
        super.name = name;
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
    public void adjustBoundsAndCursor(Glyph child, Cursor cursor) {
        int childWidth = child.getBounds().getWidth();
        int childHeight = child.getBounds().getHeight();

        bounds.setHeight(bounds.getHeight() + childHeight);
        bounds.setWidth(bounds.getWidth() > childWidth ? bounds.getWidth() : childWidth);

        cursor.setY(cursor.getY() + childHeight);
    }

    @Override
    public void adjustSelf(Cursor cursor) {
    }

    @Override
    public String toString() {
        return "Column{" + "bounds=" + bounds + '}';
    }
}
