// Composite(163).Component
//Decorator(175).Component
package glyph;

import compositor.Cursor;
import window.Window;

public abstract class Glyph {

    Glyph parent;
    String name;
    Bounds bounds = new Bounds(0, 0, 0, 0);

    public abstract void draw(Window window);

    public abstract void setSize(Window window);

    public abstract void setPosition(Cursor cursor);

    public Bounds getBounds() {
        return bounds;
    }

    public abstract boolean intersects(Cursor point);

    public abstract void insert(Glyph glyph, int position) throws GlyphException;

    public abstract void remove(Glyph glyph);

    public abstract Glyph getChild(int position);

    public abstract Glyph getParent();

    public void compose() throws GlyphException {
        // at root and not a Composition
        if (this.getParent() == null) {
            throw new GlyphException("Root glyph can only be a Composition object");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
