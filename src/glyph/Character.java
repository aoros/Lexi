package glyph;

import java.awt.Point;
import window.Window;

public class Character implements Glyph {

    private final Glyph parent;
    private final char c;
    private final Rect rect;

    public Character(Glyph parent, char c, Rect rect) {
        this.parent = parent;
        this.c = c;
        this.rect = rect;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, rect.getX(), rect.getY());
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
        throw new UnsupportedOperationException("Character is leaf Glyph.");
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Character is leaf Glyph.");
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
