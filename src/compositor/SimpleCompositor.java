package compositor;

import glyph.Bounds;
import glyph.Composition;
import glyph.Glyph;
import window.Window;

// Composite(163).Client
// Strategy(315).ConcreteStrategy
public class SimpleCompositor implements Compositor {

    Composition composition;
    Window window;

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void compose() {
        composition.getBounds().setHeight(0);
        composition.getBounds().setWidth(0);

        Bounds cursor = new Bounds(composition.getBounds().getX(), composition.getBounds().getY(), 0, 0);

        Glyph parent = composition;
        int i = 0;
        while (true) {
            try {
                Glyph child = parent.getChild(i);
                child.setSize(window);
                child.setPosition(cursor);
                child.compose();
                parent.adjustCursorAfterComposingChild(cursor, child.getBounds());
                i++;
            } catch (Exception ex) {
                break;
            }
        }
    }
}
