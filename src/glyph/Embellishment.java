package glyph;

import compositor.Cursor;
import window.Window;

public abstract class Embellishment extends Glyph {

    private Glyph glyph;

    public Embellishment(Glyph glyph) {
        this.glyph = glyph;
    }

    public Glyph getGlyph() {
        return glyph;
    }

    public void setComposition(Composition composition) {
        this.glyph = composition;
    }

    @Override
    public void compose() throws GlyphException {
        this.glyph.compose();
    }

    @Override
    public void setName(String name) {
        this.glyph.setName(name);
    }

    @Override
    public String getName() {
        return this.glyph.getName();
    }

    @Override
    public Glyph getParent() {
        return parent;
    }

    @Override
    public Glyph getChild(int position) {
        return this.glyph.getChild(position);
    }

    @Override
    public void remove(Glyph glyph) {
        this.glyph.remove(glyph);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        this.glyph.insert(glyph, position);
    }

    @Override
    public boolean intersects(Cursor point) {
        return this.glyph.intersects(point);
    }

    @Override
    public Bounds getBounds() {
        return this.glyph.getBounds();
    }

    @Override
    public void setPosition(Cursor cursor) {
        this.glyph.setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        this.glyph.setSize(window);
    }

    @Override
    public void draw(Window window) {
        this.glyph.draw(window);
    }

    @Override
    public String toString() {
        return "Embellishment{" + "composition=" + glyph + '}';
    }
}
