package glyph;

import window.Window;

// Composite(163).Composite
// Decorator(175).ConcreteComponent
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
//            System.out.println(e);
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
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds childBounds) {
        _bounds.setHeight(cursor.getY() + childBounds.getHeight() - _bounds.getY());

        if (_bounds.getWidth() < childBounds.getWidth()) {
            _bounds.setWidth(childBounds.getWidth());
        }

        cursor.setX(_bounds.getX());
        cursor.setY(_bounds.getY() + _bounds.getHeight());
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
