// Composite(163).Composite
package glyph;

import compositor.Cursor;
import java.util.ArrayList;
import java.util.List;
import window.Window;

public abstract class CompositeGlyph extends Composition {

    private final List<Glyph> children = new ArrayList<>();

    @Override
    public Glyph getParent() {
        return parent;
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    @Override
    public void draw(Window window) {
        for (Glyph glyph : children) {
            glyph.draw(window);
        }
    }

    @Override
    public void insert(Glyph glyph, int position) {
        children.add(position, glyph);
        compositor.compose();
    }

    @Override
    public void remove(Glyph glyph) {
        children.remove(glyph);
    }

    @Override
    public Glyph getChild(int position) {
        return children.get(position);
    }

    @Override
    public boolean intersects(Cursor point) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
