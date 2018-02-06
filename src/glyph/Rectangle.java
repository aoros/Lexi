package glyph;

import java.awt.Point;
import window.Window;

public class Rectangle implements Glyph {

    private final Glyph parent;
    private final Rect rect;

    public Rectangle(Glyph parent, Rect rect) {
        this.parent = parent;
        this.rect = rect;
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    @Override
    public Rect getBounds() {
        return rect;
    }

    @Override
    public boolean intersects(Point point) {
        return rect.containsCoordinate(point.x, point.y);
    }

    @Override
    public void insert(Glyph glyph, int position) {
        throw new UnsupportedOperationException("Rectangle is leaf Glyph.");
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Rectangle is leaf Glyph.");
    }

    @Override
    public Glyph getChild(int position) {
        return null;
    }

    @Override
    public Glyph getParent() {
        return parent;
    }

}
