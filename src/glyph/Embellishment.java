package glyph;

import compositor.Compositor;
import iterator.Iterator;
import visitor.GlyphVisitor;
import window.Window;

// Decorator(175).Decorator
// Visitor(331).ConcreteElement
public abstract class Embellishment extends CompositeGlyph {

    public Embellishment(Composition composition) {
        super(composition.window);
        super.addChild(composition);
    }

    @Override
    public void setCompositor(Compositor compositor) {
        super.setCompositor(compositor);
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().setCompositor(compositor);
    }

    @Override
    public void draw(Window window) {
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().draw(window);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) {
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().remove(glyph);
    }

    @Override
    public Bounds getBounds() {
        Iterator<Glyph> iter = super.createIterator();
        return iter.currentItem().getBounds();
    }

    @Override
    public String getName() {
        Iterator<Glyph> iter = super.createIterator();
        return iter.currentItem().getName();
    }

    @Override
    public void compose() {
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().compose();
    }

    @Override
    public void setPosition(Bounds cursor) {
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        Iterator<Glyph> iter = super.createIterator();
        iter.currentItem().setSize(window);
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        visitor.visit(this);
    }
}
