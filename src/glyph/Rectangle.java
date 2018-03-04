// Composite(163).Leaf
package glyph;

import compositor.Cursor;
import window.Window;

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
    public Glyph getParent() {
        return parent;
    }

    @Override
    public boolean intersects(Cursor point) {
        return false;
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

    @Override
    public void setSize(Window window) {
    }

    @Override
    public void setPosition(Cursor cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    @Override
    public Bounds getBounds() {
        return _bounds;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "bounds=" + _bounds + '}';
    }

    @Override
    public void compose() {
    }

    @Override
    public void adjustCursorBeforeComposingChild(Cursor cursor) {
    }

    @Override
    public void adjustCursorAfterComposingChild(Cursor cursor, Bounds bounds) {
    }

    @Override
    public void adjustBounds(Cursor cursor) {
    }
}
