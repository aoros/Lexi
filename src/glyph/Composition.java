// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.Compositor;
import compositor.Cursor;
import compositor.SimpleCompositor;
import window.Window;

public abstract class Composition extends Glyph {

    Compositor compositor;
    Window window;

    public Composition(Window window) {
        this.window = window;
        this.compositor = new SimpleCompositor();
        compositor.setComposition(this);
        compositor.setWindow(window);
    }
    
    @Override
    public void compose() {
        compositor.compose();
    }

    @Override
    public abstract void adjustBoundsAndCursor(Glyph glyph, Cursor cursor);

}
