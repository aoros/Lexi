package glyph;

import command.Command;
import compositor.Compositor;
import window.Window;

// Composite(163).Component
// Decorator(175).Component
public abstract class Glyph {

    Compositor compositor;
    Glyph parent;
    String name;
    Bounds _bounds = new Bounds(0, 0, 0, 0);

    public void setPosition(Bounds cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    public Bounds getBounds() {
        return _bounds;
    }

    public Glyph getParent() {
        return parent;
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    public void compose() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompositor(Compositor compositor) {
    }

    public boolean intersects(Bounds point) {
        int thisX_low = _bounds.getX();
        int thisX_high = _bounds.getX() + _bounds.getWidth();
        int thisY_low = _bounds.getY();
        int thisY_high = _bounds.getY() + _bounds.getHeight();

        return point.getX() >= thisX_low && point.getX() <= thisX_high
                && point.getY() >= thisY_low && point.getY() <= thisY_high;
    }

    public Glyph getRoot() {
        Glyph root = this;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        return root;
    }

    public Command click() {
        return null;
    }

    public abstract void insert(Glyph glyph, int position) throws GlyphException;

    public abstract void remove(Glyph glyph);

    public abstract Glyph getChild(int position);

    public abstract void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds);

    public abstract void draw(Window window);

    public abstract void setSize(Window window);
}
