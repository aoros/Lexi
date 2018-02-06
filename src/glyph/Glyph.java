package glyph;


import java.awt.Point;
import window.Window;

public interface Glyph {

    // responsibility: appearance
    void draw(Window window);

    // responsibility: appearance
    void bounds();

    // responsibility: hit detection
    boolean intersects(Point p);

    // responsibility: structure
    void insert(Glyph glyph, int i);

    // responsibility: structure
    void remove(Glyph glyph);

    // responsibility: structure
    Glyph child(int i);

    // responsibility: structure
    Glyph parent();
}
