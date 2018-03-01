// Composite(163).Client
// Strategy(315).ConcreteStrategy
package compositor;

import glyph.Composition;
import glyph.Glyph;
import window.Window;

public class SimpleCompositor implements Compositor {

    private Composition composition;
    private Window window;

    public SimpleCompositor() {
    }

    @Override
    public void setWindow(Window window) {
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

        int i = 0;
        while (true) {
            try {
                Glyph child = composition.getChild(i);
                child.setSize(window);
                child.setPosition(cursor);
                child.compose();
                composition.adjustBoundsAndCursor(child, cursor);
                i++;
            } catch (Exception ex) {
                break;
            }
        }

        composition.adjustSelf(cursor);
    }

    private void debugPrint(String msg) {
        if (window.getDebug()) {
            System.out.println(msg);
        }
    }
}
