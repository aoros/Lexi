//Decorator(175).ConcreteDecoratorB
package glyph;

import compositor.Cursor;
import window.Window;

public class Scroller extends Embellishment {

    private int scrollbarWidth = 10;

    public Scroller(Glyph glyph) {
        super(glyph);
    }

    public Scroller(Glyph glyph, int scrollbarWidth) {
        super(glyph);
        this.scrollbarWidth = scrollbarWidth;
    }

    @Override
    public void setSize(Window window) {
        _glyph.setSize(window);
        _glyph.getBounds().setWidth(_glyph.getBounds().getWidth() + scrollbarWidth);
        _glyph.getBounds().setHeight(_glyph.getBounds().getHeight());
    }

    @Override
    public void setPosition(Cursor cursor) {
        _glyph.setPosition(cursor);
    }

    @Override
    public void draw(Window window) {
        _glyph.draw(window);

        int x = _glyph.getBounds().getX() + _glyph.getBounds().getWidth() - scrollbarWidth;
        int y = _glyph.getBounds().getY();
        int w = scrollbarWidth;
        int h = _glyph.getBounds().getHeight();

        window.addScrollBar(x, y, w, h);
    }
}
