// Composite(163).Leaf
package glyph;

import compositor.Cursor;
import window.Window;

public class Character extends Glyph {

    private final char c;

    public Character(char c) {
        this.c = c;
        this.name = "char_" + c;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, bounds.getX(), bounds.getY());
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
        bounds.setWidth(window.charWidth(c));
        bounds.setHeight(window.charHeight(c));
    }

    @Override
    public void setPosition(Cursor cursor) {
        bounds.setX(cursor.getX());
        bounds.setY(cursor.getY());
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    @Override
    public String toString() {
        return "Character{" + "c=" + c + ", bounds=" + bounds + '}';
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adjustSelf(Cursor cursor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void compose() {
    }
}
