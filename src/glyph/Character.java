package glyph;

import iterator.Iterator;
import iterator.NullIterator;
import visitor.GlyphVisitor;
import window.Window;

// Composite(163).Leaf
// Iterator(257).ConcreteAggregate
// Visitor(331).ConcreteElement
public class Character extends Glyph {

    private final char c;

    public Character(char c) {
        this.c = c;
        this.name = "char_" + c;
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }

    public char getChar() {
        return c;
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
    public boolean intersects(Bounds point) {
        int thisX_low = _bounds.getX();
        int thisX_high = _bounds.getX() + _bounds.getWidth();
        int thisY_low = _bounds.getY();
        int thisY_high = _bounds.getY() + _bounds.getHeight();

        return point.getX() >= thisX_low && point.getX() <= thisX_high
                && point.getY() >= thisY_low && point.getY() <= thisY_high;
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }

    @Override
    public String toString() {
        return "Character{" + "c=" + c + ", bounds=" + _bounds + " parentName=" + parent.getName() + '}';
    }
}
