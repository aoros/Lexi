// Composite(163).Leaf
package glyph;

import window.Window;

public class Character extends Glyph {

    private final char c;

    public Character(char c) {
        this.c = c;
        this.name = "char_" + c;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, _bounds.getX(), _bounds.getY());
    }

    @Override
    public boolean intersects(Bounds point) {
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
        _bounds.setWidth(window.charWidth(c));
        _bounds.setHeight(window.charHeight(c));
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
    }

    @Override
    public String toString() {
        return "Character{" + "c=" + c + ", bounds=" + _bounds + " parentName=" + parent.getName() + '}';
    }
}
