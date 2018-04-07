package glyph;

import command.Command;
import command.SetFontSizeCommand;
import window.Window;

// Abstract Factory(87).AbstractProduct
// Factory(107).Product
public abstract class Button extends Embellishment {

    public Button(Composition composition) {
        super(composition);
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
        return new SetFontSizeCommand(window);
    }
}
