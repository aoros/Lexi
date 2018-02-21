// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.Compositor;
import compositor.Cursor;

public abstract class Composition extends Glyph {

    Compositor compositor;

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
        compositor.setComposition(this);
    }

    @Override
    public void compose() {
        compositor.compose();
    }

    @Override
    public abstract void adjustBoundsAndCursor(Glyph glyph, Cursor cursor);

}
