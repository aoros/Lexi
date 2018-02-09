package glyph;

import java.awt.Point;
import window.Window;

public abstract class Glyph {

    // responsibility: appearance
    public abstract void draw(Window window);

    // responsibility: appearance
    // returns the rectangular area that the glyph occupies
    abstract Bounds getBounds();

    // responsibility: hit detection
    abstract boolean intersects(Point point);

    // responsibility: structure
    abstract void insert(Glyph glyph, int position);

    // responsibility: structure
    abstract void remove(Glyph glyph);

    // responsibility: structure
    abstract Glyph getChild(int position);

    // responsibility: structure
    abstract Glyph getParent();
}
