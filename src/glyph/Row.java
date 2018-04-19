package glyph;

import visitor.GlyphVisitor;
import window.Window;

// Composite(163).Composite
// Decorator(175).ConcreteComponent
// Visitor(331).ConcreteElement
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
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds childBounds) {
        _bounds.setWidth(cursor.getX() + childBounds.getWidth() - _bounds.getX());

        if (_bounds.getHeight() < childBounds.getHeight())
            _bounds.setHeight(childBounds.getHeight());

        cursor.setX(_bounds.getX() + _bounds.getWidth());
        cursor.setY(_bounds.getY());
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        if (parent != null)
            return "Row{" + "name=" + name + " bounds=" + _bounds + " parentName=" + parent.getName() + '}';
        else
            return "Row{" + "name=" + name + " bounds=" + _bounds + " root}";
    }
}
