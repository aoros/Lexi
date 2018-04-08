package window;

import glyph.*;

// Bridge(151): Abstraction
public abstract class Window {

    final WindowImp _windowImp;

    public Window(String title) {
        _windowImp = WindowImpFactory.getInstance(title, this);
    }

    public void drawCharacter(char c, int x, int y) {
        _windowImp.drawCharacter(c, x, y);
    }

    public void drawRectangle(int x, int y, int width, int height) {
        _windowImp.drawRectangle(x, y, width, height);
    }

    public int charWidth(char c) {
        return _windowImp.charWidth(c);
    }

    public int charHeight(char c) {
        return _windowImp.charHeight(c);
    }

    public void addBorder(int x1, int y1, int x2, int y2, int width) {
        _windowImp.addBorder(x1, y1, x2, y2, width);
    }

    public void addScrollBar(int x, int y, int width, int height) {
        _windowImp.addScrollBar(x, y, width, height);
    }

    public void drawButton(int x, int y, int width, int height, String color) {
        _windowImp.drawButton(x, y, width, height, color);
    }

    public void drawLabel(int x, int y, int width, int height, String color) {
        _windowImp.drawLabel(x, y, width, height, color);
    }

    public int getFontSize() {
        return _windowImp.getFontSize();
    }

    public void setFontSize(int size) {
        _windowImp.setFontSize(size);
    }

    public abstract void setContents(Glyph glyph);

    public abstract void draw();

    public abstract void key(char keyChar);

    public abstract void click(int x, int y);
}
