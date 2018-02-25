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
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(composition.getClass().getName());
        System.out.println(" 0. cursor: " + cursor);

        int i = 0;
        while (true) {
            try {
                Glyph child = composition.getChild(i);
                System.out.println("   1. getChild(" + i + "): " + child.getClass().getName());
                child.setSize(window);
                System.out.println("   2. child.setSize(window): " + child);
                child.setPosition(cursor);
                System.out.println("   3. child.setPosition(cursor): " + child);
                System.out.println("   4. child.compose()");
                child.compose();
                composition.adjustBoundsAndCursor(child, cursor);
                System.out.println("   5. composition.adjustBoundsAndCursor(child, cursor):");
                System.out.println("                child: " + child);
                System.out.println("                cursor: " + cursor);
                i++;
            } catch (Exception ex) {
                break;
            }
        }
        System.out.println(" 6. Exiting compose");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
