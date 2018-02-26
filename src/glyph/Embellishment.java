package glyph;

import compositor.Cursor;
import compositor.SimpleCompositor;
import window.Window;

public abstract class Embellishment extends Composition {

    private Composition composition;
    
    public Embellishment(Composition composition, int padding) {
        super(composition.window);
        this.composition = composition;
        this.compositor = new SimpleCompositor();
        compositor.setComposition(this);
        compositor.setWindow(window);
        this.padding = padding;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void adjustBoundsAndCursor(Glyph glyph, Cursor cursor) {
        this.composition.adjustBoundsAndCursor(glyph, cursor);
    }

    @Override
    public void compose() {
        this.composition.compose();
    }

    @Override
    public void setName(String name) {
        this.composition.setName(name);
    }

    @Override
    public String getName() {
        return this.composition.getName();
    }

    @Override
    public Glyph getParent() {
        return this.composition.getParent();
    }

    @Override
    public Glyph getChild(int position) {
        return this.composition.getChild(position);
    }

    @Override
    public void remove(Glyph glyph) {
        this.composition.remove(glyph);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        this.composition.insert(glyph, position);
    }

    @Override
    public boolean intersects(Cursor point) {
        return this.composition.intersects(point);
    }

    @Override
    public Bounds getBounds() {
        return this.composition.getBounds();
    }

    @Override
    public void setPosition(Cursor cursor) {
        this.composition.setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        this.composition.setSize(window);
    }

    @Override
    public void draw(Window window) {
        this.composition.draw(window);
    }

    @Override
    public String toString() {
        return "Embellishment{" + "composition=" + composition + '}';
    }
}
