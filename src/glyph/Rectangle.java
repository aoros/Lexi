package glyph;

import java.awt.Point;
import window.Window;

public class Rectangle extends Glyph {

    private final Glyph parent;
    private Bounds bounds;

    public Rectangle(Glyph parent, Bounds bounds) {
        this.parent = parent;
        this.bounds = bounds;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    @Override
    public Glyph getParent() {
        return parent;
    }

    @Override
    public boolean intersects(Point point) {
        return bounds.containsCoordinate(point.x, point.y);
    }

    @Override
    public void insert(Glyph glyph, int position) {
        throw new UnsupportedOperationException("Rectangle glyph is a leaf node.");
    }

    @Override
    public Glyph getChild(int position) {
        throw new UnsupportedOperationException("Rectangle glyph is a leaf node.");
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Rectangle glyph is a leaf node.");
    }
}
