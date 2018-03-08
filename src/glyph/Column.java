// Composite(163).Composite
//Decorator(175).ConcreteComponent
package glyph;

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
    public void setPosition(Bounds cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    @Override
    public void adjustCursorBeforeComposingChild(Bounds cursor) {
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds childBounds) {
        _bounds.setWidth(_bounds.getWidth() > childBounds.getWidth() ? _bounds.getWidth() : childBounds.getWidth());
        _bounds.setHeight(cursor.getY() + childBounds.getHeight());

        cursor.setX(cursor.getX());
        cursor.setY(cursor.getY() + childBounds.getHeight());
        cursor.setWidth(_bounds.getWidth());
        cursor.setHeight(cursor.getY() - _bounds.getY());
    }

    @Override
    public void adjustBounds(Bounds cursor) {
        _bounds.setWidth(cursor.getWidth());
        _bounds.setHeight(cursor.getHeight());
    }

    @Override
    public String toString() {
        if (parent != null) {
            return "Column{" + "name=" + name + "bounds=" + _bounds + " parentName=" + parent.getName() + '}';
        } else {
            return "Column{" + "name=" + name + "bounds=" + _bounds + " parentName=root" + '}';
        }

    }
}
