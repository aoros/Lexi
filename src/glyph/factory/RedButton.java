package glyph.factory;

import glyph.Bounds;
import glyph.Button;
import glyph.ActionType;
import glyph.Composition;
import window.Window;

// Abstract Factory(87).ConcreteProduct
// Factory(107).ConcreteProduct
public class RedButton extends Button {

    protected RedButton(Composition composition, ActionType actionType) {
        super(composition, actionType);
        
    }

    @Override
    public void draw(Window window) {
        drawButton(window);
        super.draw(window);
    }

    private void drawButton(Window window) {
        int x = super.getBounds().getX();
        int y = super.getBounds().getY();
        int w = super.getBounds().getWidth();
        int h = super.getBounds().getHeight();

        window.drawButton(x, y, w, h, "red");
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
