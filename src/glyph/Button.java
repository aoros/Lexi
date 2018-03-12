// Abstract Factory(87).AbstractProduct
// Factory(107).Product
package glyph;

import window.Window;

public abstract class Button extends Glyph {

    final String _text;

    public Button(String text) {
        this._text = text;
    }

    public abstract void press();

    @Override
    public void setSize(Window window) {
        int glyphWidth = 0;
        int glyphHeight = 0;

        for (char c : _text.toCharArray()) {
            glyphWidth += window.charWidth(c);
            glyphHeight = Math.max(glyphHeight, window.charHeight(c));
        }

        this.getBounds().setWidth(glyphWidth);
        this.getBounds().setHeight(glyphHeight);
    }

    @Override
    public void setPosition(Bounds cursor) {
        this.getBounds().setX(cursor.getX());
        this.getBounds().setY(cursor.getY());
    }

    @Override
    public boolean intersects(Bounds point) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Glyph getChild(int position) throws GlyphException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Glyph getParent() {
        return parent;
    }

    @Override
    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    @Override
    public void adjustCursorBeforeComposingChild(Bounds cursor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void adjustBounds(Bounds cursor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
