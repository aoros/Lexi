// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.Compositor;
import window.Window;

public abstract class Composition extends Glyph {

    Compositor compositor;
    Window window;

    public Composition(Window window) {
        this.window = window;
    }

    public abstract void resetBounds();
}
