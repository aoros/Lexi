package iterator;

import glyph.CompositeGlyph;
import glyph.Glyph;
import java.util.ArrayList;
import java.util.List;

public class ListIterator extends Iterator {

    private int index = 0;
    List<Glyph> children = new ArrayList<>();

    public ListIterator(CompositeGlyph glyph) {
        this.children = glyph.getChildren();
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean isDone() {
        return index >= children.size();
    }

    @Override
    public Glyph currentItem() {
        return children.get(index);
    }
}
