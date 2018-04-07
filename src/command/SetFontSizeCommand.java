package command;

import glyph.Glyph;
import window.Window;

public class SetFontSizeCommand implements Command {

    private Glyph _glyph;
    private Window _window;

    public SetFontSizeCommand(Glyph _glyph, Window _window) {
        this._glyph = _glyph;
        this._window = _window;
    }

    public SetFontSizeCommand(Window _window) {
        this._glyph = null;
        this._window = _window;
    }

    @Override
    public void execute() {
        _window.setFontSize(20);
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Command clone() {
        Command copy = null;
        try {
            copy = (SetFontSizeCommand) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return copy;
    }

}
