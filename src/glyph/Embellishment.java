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
//        super.getChild(0).setCompositor(compositor);
    }

    @Override
    public void draw(Window window) {
        super.createIterator().currentItem().draw(window);
//        super.getChild(0).draw(window);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        super.createIterator().currentItem().insert(glyph, position);
//        super.getChild(0).insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) {
        super.createIterator().currentItem().remove(glyph);
//        super.getChild(0).remove(glyph);
    }

    @Override
    public Glyph getChild(int position) {
//        Glyph child = super.getChild(0);
        return super.createIterator().currentItem();
    }

    @Override
    public Bounds getBounds() {
        return super.createIterator().currentItem().getBounds();
//        return super.getChild(0).getBounds();
    }

    @Override
    public String getName() {
        return super.createIterator().currentItem().getName();
//        return super.getChild(0).getName();
    }

    @Override
    public void compose() {
        super.createIterator().currentItem().compose();
//        super.getChild(0).compose();
    }

    @Override
    public void setPosition(Bounds cursor) {
        super.createIterator().currentItem().setPosition(cursor);
//        super.getChild(0).setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        super.createIterator().currentItem().setSize(window);
//        super.getChild(0).setSize(window);
    }
}
