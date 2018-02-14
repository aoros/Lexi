// Composite(163).Leaf
package glyph;

import compositor.Cursor;
import window.Window;

public class Character extends Glyph {

    private Glyph parent;
    private final char c;
    private int x;
    private int y;
    private int width;
    private int height;

    public Character(char c) {
        this.c = c;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, x, y);
    }

    @Override
    public Glyph getParent() {
        return parent;
    }

    @Override
    public boolean intersects(Cursor point) {
        return false;
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

    @Override
    public void setSize(Window window) {
        width = window.charWidth(c);
        height = window.charHeight(c);
    }

    @Override
    public void setPosition(Cursor cursor) {
        x = cursor.getX();
        y = cursor.getY();
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, width, height);
    }

    @Override
    public void compose() {

    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Character{" + "parent=" + parent + ", c=" + c + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + '}';
    }
}
