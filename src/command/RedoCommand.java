package command;

import glyph.Glyph;
import window.Window;

public class RedoCommand implements Command {

    private Window _window;
    private Glyph _glyph;

    public RedoCommand(Glyph glyph, Window window) {
        this._window = window;
        this._glyph = glyph;
    }

    @Override
    public void execute() {
        Command c = CommandHistory.getInstance().getCommandForRedo();
        if (c != null)
            c.execute();
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Command clone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setGlyph(Glyph _glyph) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Glyph getGlyph() {
        return _glyph;
    }
}
