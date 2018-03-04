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

    public abstract Glyph getChild(int position) throws GlyphException;

    public abstract Glyph getParent();

    public abstract void compose();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void adjustBoundsAndCursor(Glyph glyph, Cursor cursor);

    public abstract void adjustSelf(Cursor cursor);

    public Glyph getRoot() {
        Glyph curr = this;
        Glyph p = this.getParent();
        while (p != null) {
            curr = p;
            p = p.getParent();
        }
        return curr;
    }

    public abstract void adjustCursorBeforeComposingChild(Cursor cursor);

    public abstract void adjustCursorAfterComposingChild(Cursor cursor, Bounds bounds);

    public abstract void adjustBounds(Cursor cursor);
}
