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
        debugPrint("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        debugPrint(composition.getName() + ":   " + composition.getClass().getName());
        debugPrint(" 0. cursor: " + cursor);

        int i = 0;
        while (true) {
            try {
                Glyph child = composition.getChild(i);
                debugPrint("   1. getChild(" + i + "): " + child.getName());
                child.setSize(window);
                debugPrint("   2. child.setSize(window): " + child);
                child.setPosition(cursor);
                debugPrint("   3. child.setPosition(cursor): " + child);
                debugPrint("   4. child.compose()");
                child.compose();
                composition.adjustBoundsAndCursor(child, cursor);
                debugPrint("   5. composition.adjustBoundsAndCursor(child, cursor):");
                debugPrint("                child: " + child);
                debugPrint("                cursor: " + cursor);
                i++;
            } catch (Exception ex) {
                break;
            }
        }

		composition.adjustSelf(cursor);
		
        debugPrint(" 6. Exiting compose");
        debugPrint(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    private void debugPrint(String msg) {
        if (window.getDebug())
            System.out.println(msg);
    }
}
