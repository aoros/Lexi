// Abstract Factory(87).ConcreteProduct
// Factory(107).ConcreteProduct
package glyph.factory;

import glyph.Bounds;
import glyph.Composition;
import glyph.Label;
import window.Window;

public class GreenLabel extends Label {

    protected GreenLabel(Composition composition) {
        super(composition);
    }

    public void draw(Window window) {
        super.draw(window);
        drawLabel(window);
    }

    private void drawLabel(Window window){
        int x = super.getBounds().getX();
        int y = super.getBounds().getY();
        int w = super.getBounds().getWidth();
        int h = super.getBounds().getHeight();

        window.drawLabel(x, y, w, h, "green");
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
