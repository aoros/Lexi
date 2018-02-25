package glyph;

import window.Window;

public class Border extends Embellishment {

    private Composition composition;

    public Border(Composition composition) {
        super(composition);
        this.composition = composition;
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
        int x1 = composition.getBounds().getX();
        int y1 = composition.getBounds().getY();
        int x2 = composition.getBounds().getX() + composition.getBounds().getWidth();
        int y2 = composition.getBounds().getY() + composition.getBounds().getHeight();
        window.addBorder(x1, y1, x2, y2, 5);
    }

}
