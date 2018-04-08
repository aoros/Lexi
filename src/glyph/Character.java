package glyph;

import command.Command;
import command.InsertCharacterCommand;
import window.Window;

// Composite(163).Leaf
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
    public Command click() {
        return new InsertCharacterCommand();
    }

    @Override
    public boolean intersects(Bounds point) {
        int thisX_low = _bounds.getX();
        int thisX_high = _bounds.getX() + _bounds.getWidth();
        int thisY_low = _bounds.getY();
        int thisY_high = _bounds.getY() + _bounds.getHeight();

        return point.getX() >= thisX_low && point.getX() <= thisX_high
                && point.getY() >= thisY_low && point.getY() <= thisY_high;
    }

    @Override
    public String toString() {
        return "Character{" + "c=" + c + ", bounds=" + _bounds + " parentName=" + parent.getName() + '}';
    }
}
