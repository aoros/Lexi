// Composite(163).Client
// Strategy(315).ConcreteStrategy
package compositor;

import glyph.Composition;
import glyph.Glyph;
import glyph.GlyphException;
import window.Window;

public class SimpleCompositor implements Compositor {

    Composition composition;
    Window window;

    public SimpleCompositor(Window window) {
        this.window = window;
    }

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {

        // create cursor based on parent
        Cursor cursor = new Cursor(composition.getBounds().getX(), composition.getBounds().getY());
        composition.resetBounds();
        Glyph parent = composition;
        try {
            Glyph child;
            for (int i = 0; (child = parent.getChild(i)) != null; i++) {
                child.setSize(window);
                child.setPosition(cursor);
                child.compose();
                parent.adjustBoundsAndCursor(child, cursor);
            }
        } catch (GlyphException ex) {
        }
        parent.adjustSelf(cursor);
    }
    
    @Override
    public void composeRoot() {
        Glyph root = composition.getRoot();
        if (root != null)
            root.compose();
    }

    private void debugPrint(String msg) {
        if (window.getDebug()) {
            System.out.println(msg);
        }
    }
}
