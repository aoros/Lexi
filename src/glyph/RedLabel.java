package glyph;

import window.Window;

public class RedLabel extends Label {

    public RedLabel(String text) {
        super(text);
    }

    @Override
    public void draw(Window window) {
        int x = getBounds().getX();
        int y = getBounds().getY();
        int w = getBounds().getWidth();
        int h = getBounds().getHeight();

        window.drawLabel(x, y, w, h, "red");
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
