package glyph;

import compositor.Cursor;
import window.Window;

public class Embellishment extends Glyph {

    private final Composition composition;

    public Embellishment(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void draw(Window window) {
        composition.draw(window);
    }

    @Override
    public void setSize(Window window) {
        composition.setSize(window);
    }

    @Override
    public void setPosition(Cursor cursor) {
        composition.setPosition(cursor);
    }

    @Override
    public Bounds getBounds() {
        return composition.getBounds();
    }

    @Override
    public boolean intersects(Cursor point) {
        return composition.intersects(point);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        composition.insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) {
        composition.remove(glyph);
    }

    @Override
    public Glyph getChild(int position) {
        return composition.getChild(position);
    }

    @Override
    public Glyph getParent() {
        return composition.getParent();
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        composition.adjustBoundsAndCursor(glyph, cursor);
    }

}
