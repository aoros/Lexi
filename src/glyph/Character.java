package glyph;

import java.awt.Point;
import window.Window;

public class Character implements Glyph {

    private char c;
    private int x;
    private int y;

    public Character(char c, int x, int y) {
        this.c = c;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Window window) {
        window.drawCharacter(c, x, y);
    }

    @Override
    public void getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean intersects(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Glyph glyph, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Glyph glyph) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Glyph getChild(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Glyph getParent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
