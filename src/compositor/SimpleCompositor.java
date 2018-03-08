// Composite(163).Client
// Strategy(315).ConcreteStrategy
package compositor;

import debug.DebugUtils;
import glyph.Bounds;
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
        debugPrint("=== ENTERING ========================================================");
        // create cursor based on parent
        Bounds cursor = new Bounds(composition.getBounds().getX(), composition.getBounds().getY(), 0, 0);

        Glyph parent = composition;
        debugPrint("parent --> " + parent.getName());
        debugPrint(parent, " ");
        debugPrint("   0. cursor: " + cursor.toString());
        try {
            Glyph child;
            for (int i = 0; (child = parent.getChild(i)) != null; i++) {
                debugPrint("      child before compose --> " + child.getName());
                debugPrint(child, "       ");
                parent.adjustCursorBeforeComposingChild(cursor);
                debugPrint("      2. (cursor): " + cursor.toString());
                child.setSize(window);
                child.setPosition(cursor);
                debugPrint("      calling child.compose()");
                child.compose();
                debugPrint("      child after compose --> " + child.getName());
                debugPrint(child, "       ");
                parent.adjustCursorAfterComposingChild(cursor, child.getBounds());
                debugPrint("      6. (cursor): " + cursor.toString());
            }
        } catch (GlyphException ex) {
        }
        parent.adjustBounds(cursor);
        debugPrint("parent --> " + parent.getName());
        debugPrint(parent, " ");
        debugPrint("=== EXITING  ========================================================");
    }

    @Override
    public void composeRoot() {
        Glyph root = composition.getRoot();
        if (root != null) {
            root.compose();
        }
    }

    private void debugPrint(String msg) {
        if (window.getDebug()) {
            System.out.println(msg);
        }
    }

    private void debugPrint(Glyph glyph, String spaces) {
        if (window.getDebug()) {
            DebugUtils.printLexiTree(glyph, spaces);
        }
    }
}
