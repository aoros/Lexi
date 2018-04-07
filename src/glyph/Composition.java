package glyph;

import compositor.Compositor;
import window.Window;

// Composite(163).Composite
// Strategy(315).Context
public abstract class Composition extends Glyph {

    Compositor _compositor;
    Window window;

    public Composition(Window window) {
        this.window = window;
    }

    @Override
    public void setCompositor(Compositor compositor) {
        _compositor = compositor;
        _compositor.setWindow(window);
        _compositor.setComposition(this);
    }

    @Override
    public void compose() {
        _compositor.compose();
    }
}
