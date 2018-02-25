// Composite(163).Composite
package glyph;

import compositor.Cursor;
import window.Window;

public class Row extends CompositeGlyph {

    public Row(Window window) {
        super(window);
    }

    public Row(Window window, String name) {
        super(window);
        super.name = name;
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
    
    public Row(String string, Window window, String name) {
        this(string, window);
        super.name = name;
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
        
        bounds.setWidth(cursor.getX() + glyph.getBounds().getWidth() - bounds.getX());
        bounds.setHeight(bounds.getHeight() > childHeight ? bounds.getHeight() : childHeight);

        cursor.setX(bounds.getX() + bounds.getWidth());
        cursor.setY(bounds.getY());
    }

    @Override
    public String toString() {
        return "Row{" + "bounds=" + bounds + '}';
    }
}
