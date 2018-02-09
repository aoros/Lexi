package glyph;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeGlyph extends Composition {

    private Glyph parent;
    private List<Glyph> children;

    public List<Glyph> createChildrenList() {
        return new ArrayList<>(children);
    }

}
