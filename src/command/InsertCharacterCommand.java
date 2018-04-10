package command;

import glyph.Glyph;

public class InsertCharacterCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void unexecute() {
    }

    @Override
    public Command clone() {
        Command copy = null;
        try {
            copy = (InsertCharacterCommand) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return copy;
    }

    @Override
    public void setGlyph(Glyph _glyph) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
