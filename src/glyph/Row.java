// Composite(163).Composite
//Decorator(175).ConcreteComponent
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
    public void setSize(Window window) {
        _bounds.setWidth(0);
        _bounds.setHeight(0);
    }

    @Override
    public void setPosition(Cursor cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    @Override
    public void adjustCursorBeforeComposingChild(Cursor cursor) {
        if (cursor.getX() == _bounds.getX() && cursor.getY() == _bounds.getY()) {
            _bounds.setWidth(0);
            _bounds.setHeight(0);
        }
        cursor.setX(_bounds.getX() + _bounds.getWidth());
        cursor.setY(_bounds.getY());
    }

    @Override
    public void adjustCursorAfterComposingChild(Cursor cursor, Bounds bounds) {
        int childWidth = bounds.getWidth();
        int childHeight = bounds.getHeight();

        _bounds.setWidth(cursor.getX() + childWidth);
        _bounds.setHeight(_bounds.getHeight() > childHeight ? _bounds.getHeight() : childHeight);

        cursor.setX(cursor.getX() + childWidth);
    }

    @Override
    public void adjustBounds(Cursor cursor) {
        _bounds.setX(cursor.getX() - _bounds.getWidth());
        _bounds.setY(cursor.getY());
    }

    @Override
    public String toString() {
        return "Row{" + "bounds=" + _bounds + '}';
    }
}
