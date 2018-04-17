package compositor;

import glyph.Bounds;
import glyph.Composition;
import glyph.Glyph;
import iterator.Iterator;
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
        Iterator iter = parent.createIterator();

        while (!iter.isDone()) {
            Glyph child = (Glyph) iter.currentItem();
            child.setSize(window);
            child.setPosition(cursor);
            child.compose();
            parent.adjustCursorAfterComposingChild(cursor, child.getBounds());
            iter.next();
        }
    }
}
