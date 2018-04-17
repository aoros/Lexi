package glyph;

import visitor.GlyphVisitor;
import window.Window;

// Decorator(175).ConcreteDecoratorA
public class Border extends Embellishment {

    private int padding = 2;

    public Border(Composition composition) {
        super(composition);
    }

    public Border(Composition composition, int padding) {
        super(composition);
        this.padding = padding;
    }

    @Override
    public void draw(Window window) {
        super.draw(window);

        int x1 = super.getBounds().getX();
        int y1 = super.getBounds().getY();
        int x2 = super.getBounds().getX() + super.getBounds().getWidth();
        int y2 = super.getBounds().getY() + super.getBounds().getHeight();

        window.addBorder(x1, y1, x2, y2, padding);
    }

    @Override
    public void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accept(GlyphVisitor visitor) {
        super.accept(visitor);
    }
}
