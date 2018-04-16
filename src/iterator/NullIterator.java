package iterator;

import glyph.Glyph;

public class NullIterator extends Iterator {

    @Override
    public void first() {
    }

    @Override
    public void next() {
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public Glyph currentItem() {
        return null;
    }

}
