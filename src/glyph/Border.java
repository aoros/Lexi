//Decorator(175).ConcreteDecoratorA
package glyph;

import window.Window;

public class Border extends Embellishment {

    private int padding = 5;
    private int maxHeight;
    private int maxWidth;

    public Border(Glyph glyph) {
        super(glyph);
    }

    public Border(Glyph glyph, int padding) {
        super(glyph);
        this.padding = padding;
    }

    @Override
    public void setSize(Window window) {
        _glyph.setSize(window);
        _glyph.getBounds().setWidth(_glyph.getBounds().getWidth() + padding * 2);
        _glyph.getBounds().setHeight(_glyph.getBounds().getHeight() + padding * 2);
        shiftGlyphAndAllChildren(_glyph);
    }

    @Override
    public void setPosition(Bounds cursor) {
        _glyph.setPosition(cursor);
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

    private void shiftGlyphAndAllChildren(Glyph glyph) {
        glyph.getBounds().setX(glyph.getBounds().getX() + padding);
        glyph.getBounds().setY(glyph.getBounds().getY() + padding);
        int i = 0;
        while (true) {
            try {
                Glyph child = glyph.getChild(i);
                child.getBounds().setX(child.getBounds().getX() + padding);
                child.getBounds().setY(child.getBounds().getY() + padding);
                i++;
            } catch (Exception ex) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Border{" + "_glyph=" + _glyph + '}';
    }
    
}
