package iterator;

import glyph.CompositeGlyph;
import java.util.ArrayList;
import java.util.List;

public class ListIterator<T extends IsIterable> extends Iterator<T> {

    private int index = 0;
    List<T> children = new ArrayList<>();

    public ListIterator(CompositeGlyph glyph) {
        this.children = (List<T>) glyph.getChildren();
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
    public T currentItem() {
        return children.get(index);
    }
}
