package glyph;

import window.Window;

// Decorator(175).ConcreteDecoratorB
public class Scroller extends Embellishment {

    private final int padding = 1;
    private final int scrollbarWidth = 10;

    public Scroller(Composition composition) {
        super(composition);
    }

    @Override
    public void draw(Window window) {
        super.draw(window);

        int x = super.getBounds().getX() + super.getBounds().getWidth();
        int y = super.getBounds().getY() + padding;
        int w = scrollbarWidth;
        int h = super.getBounds().getHeight() - padding * 2;

        window.addScrollBar(x, y, w, h);
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
