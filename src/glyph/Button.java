package glyph;

import command.Command;
import window.Window;

// Abstract Factory(87).AbstractProduct
// Factory(107).Product
public abstract class Button extends Embellishment {

    private final Command command;

    public Button(Composition composition, Command command) {
        super(composition);
        this.command = command;
    }

    @Override
    public void draw(Window window) {
        super.draw(window);
    }

    @Override
    public Bounds getBounds() {
        return super.getBounds();
    }

    @Override
    public Command click() {
        return command;
    }

    @Override
    public boolean intersects(Bounds point) {
        int thisX_low = super.getBounds().getX();
        int thisX_high = super.getBounds().getX() + super.getBounds().getWidth();
        int thisY_low = super.getBounds().getY();
        int thisY_high = super.getBounds().getY() + super.getBounds().getHeight();

        return point.getX() >= thisX_low && point.getX() <= thisX_high
                && point.getY() >= thisY_low && point.getY() <= thisY_high;
    }
}
