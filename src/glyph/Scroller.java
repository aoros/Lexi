//Decorator(175).ConcreteDecoratorB
package glyph;

import compositor.Cursor;
import window.Window;

public class Scroller extends Embellishment {

    private int scrollbarWidth = 10;
    private int maxWidth;

    public Scroller(Glyph glyph) {
        super(glyph);
    }

    public Scroller(Glyph glyph, int scrollbarWidth) {
        super(glyph);
        this.scrollbarWidth = scrollbarWidth;
    }

    @Override
    public void setSize(Window window) {
        super.setSize(window);
        getGlyph().getBounds().setWidth(getGlyph().getBounds().getWidth() + scrollbarWidth);
        getGlyph().getBounds().setHeight(getGlyph().getBounds().getHeight());
    }

    @Override
    public void setPosition(Cursor cursor) {
        super.setPosition(cursor);
        cursor.setX(cursor.getX() + scrollbarWidth);
    }

    @Override
    public void draw(Window window) {
        super.draw(window);

        int x = getGlyph().getBounds().getX() + getGlyph().getBounds().getWidth();
        int y = getGlyph().getBounds().getY();
        int w = scrollbarWidth;
        int h = getGlyph().getBounds().getHeight();

        window.addScrollBar(x, y, w, h);
    }
}
