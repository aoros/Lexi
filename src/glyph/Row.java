// Composite(163).Composite
// Decorator(175).ConcreteComponent
package glyph;

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
    }

    @Override
    public void setPosition(Bounds cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    @Override
    public void adjustCursorBeforeComposingChild(Bounds cursor) {
//        cursor.setX(_bounds.getX());
//        cursor.setY(_bounds.getY());
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds childBounds) {
        _bounds.setWidth(cursor.getX() + childBounds.getWidth());
        _bounds.setHeight(_bounds.getHeight() > childBounds.getHeight() ? _bounds.getHeight() : childBounds.getHeight());

        cursor.setX(cursor.getX() + childBounds.getWidth());
        cursor.setY(cursor.getY());
        cursor.setWidth(cursor.getX() - _bounds.getX());
        cursor.setHeight(_bounds.getHeight());
    }

    @Override
    public void adjustBounds(Bounds cursor) {
        _bounds.setWidth(cursor.getWidth());
        _bounds.setHeight(cursor.getHeight());
    }

    @Override
    public String toString() {
        if (parent != null) {
            return "Row{" + "name=" + name + " bounds=" + _bounds + " parentName=" + parent.getName() + '}';
        } else {
            return "Row{" + "name=" + name + " bounds=" + _bounds + " root}";
        }
    }
}
