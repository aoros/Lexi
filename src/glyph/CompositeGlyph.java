package glyph;

import compositor.SimpleCompositor;
import java.util.ArrayList;
import java.util.List;
import window.Window;

// Composite(163).Composite
public abstract class CompositeGlyph extends Composition {

    private final List<Glyph> children = new ArrayList<>();

    public CompositeGlyph(Window window) {
        super(window);
        super.setCompositor(new SimpleCompositor());
    }

    @Override
    public void draw(Window window) {
        for (Glyph glyph : children) {
            glyph.draw(window);
        }
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        children.add(position, glyph);
        glyph.setParent(this);
        getRoot().compose();
    }

    @Override
    public void remove(Glyph glyph) {
        children.remove(glyph);
        getRoot().compose();
    }

    @Override
    public Glyph getChild(int position) {
        try {
            return children.get(position);
        } catch (IndexOutOfBoundsException ex) {
            throw ex;
        }
    }

    public void addChild(Glyph glyph) {
        children.add(0, glyph);
        glyph.setParent(this);
    }
}
