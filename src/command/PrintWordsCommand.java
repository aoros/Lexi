package command;

import glyph.Glyph;
import iterator.Iterator;
import iterator.PreorderIterator;
import visitor.GlyphVisitor;
import visitor.WordsVisitor;
import window.Window;

// Visitor(331).ObjectStructure
// Command(233).ConcreteCommand
public class PrintWordsCommand implements Command {

    Glyph _glyph;

    public PrintWordsCommand(Glyph glyph, Window window) {
        this._glyph = glyph;
    }

    @Override
    public void execute() {
        GlyphVisitor v = new WordsVisitor();
        Iterator i = new PreorderIterator<>(_glyph);
        i.first();
        while (!i.isDone()) {
            ((Glyph) i.currentItem()).accept(v);
            i.next();
        }
        System.out.println(v);
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Command clone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGlyph(Glyph _glyph) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Glyph getGlyph() {
        return _glyph;
    }
}
