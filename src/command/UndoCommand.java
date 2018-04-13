package command;

import glyph.Glyph;
import window.Window;

public class UndoCommand implements Command {

    private Window _window;
    private Glyph _glyph;

    public UndoCommand(Glyph glyph, Window window) {
        this._window = window;
        this._glyph = glyph;
    }

    @Override
    public void execute() {
        Command command = CommandHistory.getInstance().getCommandForUndo();
        if (command != null) {
            command.unexecute();
        }
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
