// Composite(163).Component
//Decorator(175).Component
package glyph;

import compositor.Compositor;
import window.Window;

public abstract class Glyph {

    Compositor compositor;
    Glyph parent;
    String name;
    Bounds _bounds = new Bounds(0, 0, 0, 0);

    public abstract void draw(Window window);

    public abstract void setSize(Window window);

    public abstract void setPosition(Bounds cursor);

    public Bounds getBounds() {
        return _bounds;
    }

    public abstract boolean intersects(Bounds point);

    public abstract void insert(Glyph glyph, int position) throws GlyphException;

    public abstract void remove(Glyph glyph);

    public abstract Glyph getChild(int position) throws GlyphException;

    public abstract Glyph getParent();
    
    public abstract void setParent(Glyph parent);

    public void compose() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Glyph getRoot() {
        Glyph curr = this;
        Glyph p = this.getParent();
        while (p != null) {
            curr = p;
            p = p.getParent();
        }
        return curr;
    }

    public abstract void adjustCursorBeforeComposingChild(Bounds cursor);

    public abstract void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds);

    public abstract void adjustBounds(Bounds cursor);
}
