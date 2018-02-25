package glyph;

import window.Window;

public class Scroller extends Embellishment {

    private int thickness = 10;
    private Composition composition;

    public Scroller(Composition composition) {
        super(composition);
        this.composition = composition;
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
        int x = composition.getBounds().getX() + composition.getBounds().getWidth();
        int y = composition.getBounds().getY();
        window.addScrollBar(x, y, thickness, composition.getBounds().getHeight());
    }
}
