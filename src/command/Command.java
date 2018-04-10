package command;

import glyph.Glyph;

public interface Command {

    public void execute();

    public void unexecute();

    public Command clone();

    public void setGlyph(Glyph _glyph);
}
