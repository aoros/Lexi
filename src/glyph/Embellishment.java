//Decorator(175).Decorator
package glyph;

import window.Window;

public abstract class Embellishment extends Composition {

    Glyph _glyph;

    public Embellishment(Glyph glyph, Window window) {
        super(window);
        this._glyph = glyph;
    }

    @Override
    public boolean intersects(Bounds point) {
        return _glyph.intersects(point);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        _glyph.insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) {
        _glyph.remove(glyph);
    }

    @Override
    public Glyph getChild(int position) throws GlyphException {
        return _glyph.getChild(position);
    }

    @Override
    public Glyph getParent() {
        return _glyph.getParent();
    }

    @Override
    public void setParent(Glyph parent) {
        _glyph.setParent(parent);
    }

    @Override
    public Bounds getBounds() {
        return _glyph.getBounds();
    }

    @Override
    public String getName() {
        return _glyph.getName();
    }

    @Override
    public void compose() {
        _glyph.compose();
    }
}
