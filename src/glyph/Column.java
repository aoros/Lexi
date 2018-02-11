package glyph;

import window.Window;

public class Column extends CompositeGlyph {

    int x;
    int y;
    int width;
    int height;

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, width, height);
    }

    @Override
    public void setSize(Window window) {
        // set children size first
        for (Glyph glyph : children)
            glyph.setSize(window);

        for (Glyph glyph : children) {
            height += glyph.getBounds().getHeight();

            if (width < glyph.getBounds().getWidth())
                width = glyph.getBounds().getWidth();
        }
    }

    @Override
    public void setPosition(Cursor cursor) {
        x = cursor.getX();
        y = cursor.getY();

        for (Glyph glyph : children) {
            glyph.setPosition(cursor);
            cursor.setY(glyph.getBounds().getY() + glyph.getBounds().getHeight());
        }
        cursor.setX(x);
        cursor.setY(y);
    }
}
