package glyph;

import java.awt.Point;
import window.Window;

public class Character extends Glyph {

    private final Glyph parent;
    private final char c;
    private final Bounds bounds;

    public Character(char c, Glyph parent, Bounds bounds) {
        this.parent = parent;
        this.c = c;
        this.bounds = bounds;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, bounds.getX(), bounds.getY());
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
        throw new UnsupportedOperationException("Character glyph is a leaf node.");
    }

    @Override
    public Glyph getChild(int position) {
        throw new UnsupportedOperationException("Character glyph is a leaf node.");
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Character glyph is a leaf node.");
    }
}
