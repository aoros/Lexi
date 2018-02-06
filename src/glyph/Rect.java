package glyph;

public class Rect {

    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean containsCoordinate(int _x, int _y) {
        return (_x >= x && _x <= x + width && _y >= y && _y <= y + height);
    }
}
