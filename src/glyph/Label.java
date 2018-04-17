package glyph;

import visitor.GlyphVisitor;
import window.Window;

// Abstract Factory(87).AbstractProduct
// Factory(107).Product
public abstract class Label extends Embellishment {

    public Label(Composition composition) {
        super(composition);
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
    }

    @Override
    public Bounds getBounds() {
        return super.getBounds();
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        super.accept(visitor);
    }
}
