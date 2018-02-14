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
    public abstract void adjustBoundsAndCursor(Glyph glyph, Cursor cursor);

}
