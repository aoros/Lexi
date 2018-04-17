package glyph;

import iterator.Iterator;
import iterator.NullIterator;
import visitor.GlyphVisitor;
import window.Window;

// Composite(163).Leaf
public class Rectangle extends Glyph {

    public Rectangle(int width, int height) {
        _bounds.setWidth(width);
        _bounds.setHeight(height);
    }

    @Override
    public void draw(Window window) {
        window.drawRectangle(_bounds.getX(), _bounds.getY(), _bounds.getWidth(), _bounds.getHeight());
    }

    @Override
    public void insert(Glyph glyph, int position) {
        throw new UnsupportedOperationException("Rectangle glyph is a leaf node.");
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Rectangle glyph is a leaf node.");
    }

    @Override
    public void setSize(Window window) {
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "bounds=" + _bounds + " parentName=" + parent.getName() + '}';
    }
}
