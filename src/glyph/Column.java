// Composite(163).Composite
//Decorator(175).ConcreteComponent
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
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    @Override
    public void adjustCursorBeforeComposingChild(Cursor cursor) {
        if (cursor.getX() == _bounds.getX() && cursor.getY() == _bounds.getY()) {
            _bounds.setWidth(0);
            _bounds.setHeight(0);
        }
        cursor.setX(_bounds.getX());
        cursor.setY(_bounds.getY() + _bounds.getHeight());
    }

    @Override
    public void adjustCursorAfterComposingChild(Cursor cursor, Bounds bounds) {
        int childWidth = bounds.getWidth();
        int childHeight = bounds.getHeight();

        _bounds.setHeight(_bounds.getHeight() + childHeight);
        _bounds.setWidth(_bounds.getWidth() > childWidth ? _bounds.getWidth() : childWidth);

        cursor.setY(cursor.getY() + childHeight);
    }

    @Override
    public void adjustBounds(Cursor cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY() - _bounds.getHeight());
    }

    @Override
    public String toString() {
        return "Column{" + "bounds=" + _bounds + '}';
    }
}
