package command;

import glyph.Glyph;
import java.util.Objects;
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
        System.out.println(CommandHistory.getInstance().toString());
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this._window);
        hash = 53 * hash + Objects.hashCode(this._glyph);
        return hash;
    }

    @Override
    public String toString() {
        return "UndoCommand{" + hashCode() + '}';
    }
}
