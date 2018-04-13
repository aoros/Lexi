package command;

import glyph.Glyph;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this._window);
        hash = 41 * hash + Objects.hashCode(this._glyph);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RedoCommand other = (RedoCommand) obj;
        return true;
    }

    @Override
    public String toString() {
        return "RedoCommand{" + hashCode() + '}';
    }

}
