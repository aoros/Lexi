package glyph;

import java.awt.Point;
import java.util.List;
import window.Window;

public class Column extends CompositeGlyph {

    private Glyph parent;
    private List<Glyph> children;

    public Column(Glyph parent) {
        this.parent = parent;
    }

    @Override
    public Bounds getBounds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean intersects(Point point) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public Glyph getParent() {
        return parent;
    }

    @Override
    public void draw(Window window) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
