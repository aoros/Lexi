// Composite(163).Component
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

    public abstract Bounds getBounds();

    public abstract boolean intersects(Cursor point);

    public abstract void insert(Glyph glyph, int position) throws GlyphException;

    public abstract void remove(Glyph glyph);

    public abstract Glyph getChild(int position);

    public abstract Glyph getParent();

    public void compose() {
    }

    public abstract void adjustBoundsAndCursor(Glyph glyph, Cursor cursor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
