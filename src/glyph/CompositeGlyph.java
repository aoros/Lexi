// Composite(163).Composite
package glyph;

import compositor.Cursor;
import compositor.SimpleCompositor;
import java.util.ArrayList;
import java.util.List;
import window.Window;

public abstract class CompositeGlyph extends Composition {

    private final List<Glyph> children = new ArrayList<>();

    public CompositeGlyph(Window window) {
        super(window);
        this.compositor = new SimpleCompositor(window);
        compositor.setComposition(this);
    }

    @Override
    public void compose() {
        compositor.compose();
    }

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
    public void insert(Glyph glyph, int position) throws GlyphException {
        glyph.parent = this;
        children.add(position, glyph);

        // go to the root and compose from there
        Glyph current = this;
        Glyph currentParent = this.getParent();
        while (currentParent != null) {
            current = currentParent;
            currentParent = current.getParent();
        }
        current.compose();
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

    @Override
    public void resetBounds() {
        bounds.reset();
    }
}
