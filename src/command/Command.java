package command;

import glyph.Glyph;

// Command(233).Command
// Prototype(119).Prototype
public interface Command {

    public void execute();

    public void unexecute();

    public Command clone();

    public void setGlyph(Glyph _glyph);

    public Glyph getGlyph();
}
