//Decorator(175).Decorator
package glyph;

import compositor.Cursor;
import window.Window;

public abstract class Embellishment extends Glyph {

    Glyph _glyph;

    public Embellishment(Glyph glyph) {
        this._glyph = glyph;
    }

    public Glyph getGlyph() {
        return _glyph;
    }

    public void setComposition(Composition composition) {
        _glyph = composition;
    }

    @Override
    public void compose() {
        _glyph.compose();
    }

    @Override
    public void setName(String name) {
        _glyph.setName(name);
    }

    @Override
    public String getName() {
        return _glyph.getName();
    }

    @Override
    public Glyph getParent() {
        return parent;
    }

    @Override
    public Glyph getChild(int position) throws GlyphException {
        return _glyph.getChild(position);
    }

    @Override
    public void remove(Glyph glyph) {
        glyph.remove(glyph);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        _glyph.insert(glyph, position);
    }

    @Override
    public boolean intersects(Cursor point) {
        return _glyph.intersects(point);
    }

    @Override
    public Bounds getBounds() {
        return _glyph.getBounds();
    }

    @Override
    public void setPosition(Cursor cursor) {
        _glyph.setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        _glyph.setSize(window);
    }

    @Override
    public void draw(Window window) {
        _glyph.draw(window);
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        _glyph.adjustBoundsAndCursor(glyph, cursor);
    }

    @Override
    public void adjustCursorBeforeComposingChild(Cursor cursor) {
    }

    @Override
    public void adjustCursorAfterComposingChild(Cursor cursor, Bounds bounds) {
    }

    @Override
    public void adjustBounds(Cursor cursor) {
        _glyph.adjustBounds(cursor);
    }

    @Override
    public String toString() {
        return "Embellishment{" + "composition=" + _glyph + '}';
    }
}
