package glyph;

import java.awt.Point;
import java.util.List;
import window.Window;

public class Column implements Glyph {

    private Glyph parent;
    private List<Glyph> children;

    @Override
    public void draw(Window window) {
        for (Glyph glyph : children)
            glyph.draw(window);
    }

    @Override
    public Rect getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean intersects(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
