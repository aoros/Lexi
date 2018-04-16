package glyph;

import compositor.Compositor;
import window.Window;

// Decorator(175).Decorator
public abstract class Embellishment extends CompositeGlyph {

    public Embellishment(Composition composition) {
        super(composition.window);
        super.addChild(composition);
    }

    @Override
    public void setCompositor(Compositor compositor) {
        super.setCompositor(compositor);
        super.createIterator().currentItem().setCompositor(compositor);
    }

    @Override
    public void draw(Window window) {
        super.createIterator().currentItem().draw(window);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        super.createIterator().currentItem().insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) {
        super.createIterator().currentItem().remove(glyph);
    }

    @Override
    public Bounds getBounds() {
        return super.createIterator().currentItem().getBounds();
    }

    @Override
    public String getName() {
        return super.createIterator().currentItem().getName();
    }

    @Override
    public void compose() {
        super.createIterator().currentItem().compose();
    }

    @Override
    public void setPosition(Bounds cursor) {
        super.createIterator().currentItem().setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        super.createIterator().currentItem().setSize(window);
    }
}
