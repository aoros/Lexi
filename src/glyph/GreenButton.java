// Abstract Factory(87).ConcreteProduct
// Factory(107).ConcreteProduct
package glyph;

import window.Window;

public class GreenButton extends Button {

    public GreenButton(String text) {
        super(text);
    }

    @Override
    public void press() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Window window) {
        int x = getBounds().getX();
        int y = getBounds().getY();
        int w = getBounds().getWidth();
        int h = getBounds().getHeight();

        window.drawButton(x, y, w, h, "green");
        drawText(window, x, y);
    }

    private void drawText(Window window, int x, int y) {
        int newX = x;
        for (char c : _text.toCharArray()) {
            window.drawCharacter(c, newX, y);
            newX += window.charWidth(c);
        }
    }
}
