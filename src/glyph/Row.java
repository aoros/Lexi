package glyph;

import window.Window;

public class Row extends CompositeGlyph {

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
            width += glyph.getBounds().getWidth();

            if (height < glyph.getBounds().getHeight())
                height = glyph.getBounds().getHeight();
        }
    }

    @Override
    public void setPosition(Cursor cursor) {
        x = cursor.getX();
        y = cursor.getY();

        for (Glyph glyph : children) {
            glyph.setPosition(cursor);
            cursor.setX(glyph.getBounds().getX() + glyph.getBounds().getWidth());
        }
        cursor.setX(x);
        cursor.setY(y);
    }
}
