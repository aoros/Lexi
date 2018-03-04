// Composite(163).Composite
// Strategy(315).Context
package glyph;

import compositor.Compositor;
import compositor.Cursor;
import window.Window;

public abstract class Composition extends Glyph {

    Compositor compositor;
    Window window;

    public Composition(Window window) {
        this.window = window;
    }

    public abstract void resetBounds();

    @Override
    public abstract void adjustCursorBeforeComposingChild(Cursor cursor);

    @Override
    public abstract void adjustCursorAfterComposingChild(Cursor cursor, Bounds bounds);

    @Override
    public abstract void adjustBounds(Cursor cursor);
}
