// Decorator(175).ConcreteDecoratorB
package glyph;

import window.Window;

public class Scroller extends Embellishment {

    private final int scrollbarWidth = 10;

    public Scroller(Glyph glyph, Window window) {
        super(glyph, window);
    }

    @Override
    public void setSize(Window window) {
        _glyph.setSize(window);

        _glyph.getBounds().setWidth(_glyph.getBounds().getWidth() + scrollbarWidth);
        _glyph.getBounds().setHeight(_glyph.getBounds().getHeight());
    }

    @Override
    public void setPosition(Bounds cursor) {
        _glyph.setPosition(cursor);
    }

    @Override
    public void draw(Window window) {
        _glyph.draw(window);

        int x;
        if (_glyph.compositor == null)
            x = _glyph.getBounds().getX() + _glyph.getBounds().getWidth() - scrollbarWidth;
        else
            x = _glyph.getBounds().getX() + _glyph.getBounds().getWidth();
        int y = _glyph.getBounds().getY();
        int w = scrollbarWidth;
        int h = _glyph.getBounds().getHeight();

        window.addScrollBar(x, y, w, h);
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
        return "Scroller{" + "_glyph=" + _glyph + '}';
    }
}
