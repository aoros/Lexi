package glyph;

import compositor.Cursor;
import window.Window;

public abstract class Glyph {

    public abstract void draw(Window window);

    public abstract void setSize(Window window);

    public abstract void setPosition(Cursor cursor);

    public abstract Bounds getBounds();

    public abstract boolean intersects(Cursor point);

    public abstract void insert(Glyph glyph, int position);

    public abstract void remove(Glyph glyph);

    public abstract Glyph getChild(int position);

    public abstract Glyph getParent();

    public abstract void compose();

    public abstract void adjustBoundsAndCursor(Glyph glyph, Cursor cursor);
}
