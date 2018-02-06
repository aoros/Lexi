package glyph;

import java.awt.Point;
import window.Window;

public interface Glyph {

    // responsibility: appearance
    void draw(Window window);

    // responsibility: appearance
    void getBounds();

    // responsibility: hit detection
    boolean intersects(Point point);

    // responsibility: structure
    void insert(Glyph glyph, int position);

    // responsibility: structure
    void remove(Glyph glyph);

    // responsibility: structure
    Glyph getChild(int position);

    // responsibility: structure
    Glyph getParent();
}
