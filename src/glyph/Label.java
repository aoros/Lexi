// Abstract Factory(87).AbstractProduct
// Factory(107).Product
package glyph;

import window.Window;

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
}
