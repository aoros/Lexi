package glyph;

public class Bounds {

    private int x;
    private int y;
    private int width;
    private int height;
    private int paddingTop;
    private int paddinLeft;
    private int paddinRight;
    private int paddinBottom;

    public Bounds(int x, int y, int width, int height) {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean containsCoordinate(int _x, int _y) {
        return (_x >= x && _x <= x + width && _y >= y && _y <= y + height);
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddinLeft() {
        return paddinLeft;
    }

    public void setPaddinLeft(int paddinLeft) {
        this.paddinLeft = paddinLeft;
    }

    public int getPaddinRight() {
        return paddinRight;
    }

    public void setPaddinRight(int paddinRight) {
        this.paddinRight = paddinRight;
    }

    public int getPaddinBottom() {
        return paddinBottom;
    }

    public void setPaddinBottom(int paddinBottom) {
        this.paddinBottom = paddinBottom;
    }

    @Override
    public String toString() {
        return "Bounds{"
                + "x=" + x
                + ", y=" + y
                + ", width=" + width
                + ", height=" + height
                + ", paddingTop=" + paddingTop
                + ", paddinLeft=" + paddinLeft
                + ", paddinRight=" + paddinRight
                + ", paddinBottom=" + paddinBottom + '}';
    }

    void reset() {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }
}
