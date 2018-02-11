package compositor;

import glyph.Composition;
import glyph.Cursor;
import window.Window;

public class SimpleCompositor implements Compositor {

    private Composition composition;
    private Window window;

    public SimpleCompositor(Window window) {
        this.window = window;
    }

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {
        int root_x = composition.getBounds().getX();
        int root_y = composition.getBounds().getY();
        Cursor cursor = new Cursor();
        cursor.setX(root_x);
        cursor.setY(root_y);

        composition.setSize(window);
        composition.setPosition(cursor);

        window.setContents(composition);
    }

    // create cursor based on parent
    // for (... child= ...) {
    // ask (leaf) child to set size, based on window
    // ask child to set position, based on cursor
    // ask child to compose itself, recursively
    // ask parent to adjust itself and cursor, based on child
    // }
    // ask parent to adjust itself, based on cursor
}
