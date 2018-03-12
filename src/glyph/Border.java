//Decorator(175).ConcreteDecoratorA
package glyph;

import window.Window;

public class Border extends Embellishment {

    private final int padding = 2;

    public Border(Glyph glyph, Window window) {
        super(glyph, window);
    }

    @Override
    public void setSize(Window window) {
        _glyph.setSize(window);

        _glyph.getBounds().setWidth(_glyph.getBounds().getWidth() + padding * 2);
        _glyph.getBounds().setHeight(_glyph.getBounds().getHeight() + padding * 2);
    }

    @Override
    public void setPosition(Bounds cursor) {
        _glyph.setPosition(cursor);

        cursor.setX(cursor.getX() + padding);
        cursor.setY(cursor.getY() + padding);
        _glyph.getBounds().setX(cursor.getX());
        _glyph.getBounds().setY(cursor.getY());

    }

    @Override
    public void draw(Window window) {
        _glyph.draw(window);
        int x1 = _glyph.getBounds().getX();
        int y1 = _glyph.getBounds().getY();
        int x2 = _glyph.getBounds().getX() + _glyph.getBounds().getWidth();
        int y2 = _glyph.getBounds().getY() + _glyph.getBounds().getHeight();

        window.addBorder(x1, y1, x2, y2, padding);
    }

    @Override
    public void adjustCursorBeforeComposingChild(Bounds cursor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adjustBounds(Bounds cursor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Border{" + "_glyph=" + _glyph + '}';
    }
}
