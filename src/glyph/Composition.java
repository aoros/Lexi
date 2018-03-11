// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.SimpleCompositor;
import window.Window;

public abstract class Composition extends Glyph {

    Window window;

    public Composition(Window window) {
        this.window = window;
        this.compositor = new SimpleCompositor(window);
        compositor.setComposition(this);
    }
}
