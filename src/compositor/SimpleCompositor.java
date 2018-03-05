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
        debugPrint("===========================================================");
        debugPrint("compose()");
        // create cursor based on parent
        Cursor cursor = new Cursor(composition.getBounds().getX(), composition.getBounds().getY());
        
        Glyph parent = composition;
        debugPrint("   0. parent: " + parent.toString());
        debugPrint("   0. cursor: " + cursor.toString());
        try {
            Glyph child;
            for (int i = 0; (child = parent.getChild(i)) != null; i++) {
                debugPrint("      1. (child): " + child.toString());
                parent.adjustCursorBeforeComposingChild(cursor);
                debugPrint("      2. (cursor): " + cursor.toString());
                child.setSize(window);
                debugPrint("      3. (child): " + child.toString());
                child.setPosition(cursor);
                debugPrint("      4. (child): " + child.toString());
                child.compose();
                debugPrint("      5. (child): " + child.toString());
                parent.adjustCursorAfterComposingChild(cursor, child.getBounds());
                debugPrint("      6. (parent): " + parent.toString());
                debugPrint("      6. (cursor): " + cursor.toString());
            }
        } catch (GlyphException ex) {
        }
        parent.adjustBounds(cursor);
        debugPrint("   7. parent: " + parent.toString());
        debugPrint("===========================================================");
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
