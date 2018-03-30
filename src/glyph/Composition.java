// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.Compositor;
import window.Window;

public abstract class Composition extends Glyph {

    Compositor _compositor;
    Window window;

    public Composition(Window window) {
        this.window = window;
    }

    public void setCompositor(Compositor compositor) {
        _compositor = compositor;
        _compositor.setWindow(window);
        _compositor.setComposition(this);
    }

    @Override
    public void compose() {
        compositor.compose();
    }

    public Glyph getRoot(Glyph glyph) {
        Glyph root = glyph;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        return root;
    }
}
