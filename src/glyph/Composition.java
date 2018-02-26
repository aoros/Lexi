// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.Compositor;
import window.Window;

public abstract class Composition extends Glyph {

    Compositor compositor;
    Window window;
    int padding;

    public Composition(Window window) {
        this.window = window;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
}
