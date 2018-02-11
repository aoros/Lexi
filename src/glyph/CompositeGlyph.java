package glyph;

import java.util.ArrayList;
import java.util.List;
import window.Window;

public abstract class CompositeGlyph extends Composition {

    Glyph parent;
    List<Glyph> children = new ArrayList<>();

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
