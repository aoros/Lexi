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
        super.getChild(0).setCompositor(compositor);
    }

    @Override
    public void draw(Window window) {
        super.getChild(0).draw(window);
    }

    @Override
    public void insert(Glyph glyph, int position) throws GlyphException {
        super.getChild(0).insert(glyph, position);
    }

    @Override
    public void remove(Glyph glyph) {
        super.getChild(0).remove(glyph);
    }

    @Override
    public Glyph getChild(int position) {
        Glyph child = super.getChild(0);
        return child.getChild(position);
    }

    @Override
    public Bounds getBounds() {
        return super.getChild(0).getBounds();
    }

    @Override
    public String getName() {
        return super.getChild(0).getName();
    }

    @Override
    public void compose() {
        super.getChild(0).compose();
    }

    @Override
    public void setPosition(Bounds cursor) {
        super.getChild(0).setPosition(cursor);
    }

    @Override
    public void setSize(Window window) {
        super.getChild(0).setSize(window);
    }
}
