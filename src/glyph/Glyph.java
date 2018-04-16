package glyph;

import command.Command;
import compositor.Compositor;
import java.util.LinkedList;
import java.util.Queue;
import window.Window;
import iterator.IsIterable;
import iterator.Iterator;

// Composite(163).Component
// Decorator(175).Component
// Command(233).Receiver
// Chain of Responsibility(223).Handler
public abstract class Glyph implements IsIterable {

    Compositor compositor;
    Glyph parent;
    String name;
    Bounds _bounds = new Bounds(0, 0, 0, 0);

    public void setPosition(Bounds cursor) {
        _bounds.setX(cursor.getX());
        _bounds.setY(cursor.getY());
    }

    public Bounds getBounds() {
        return _bounds;
    }

    public Glyph getParent() {
        return parent;
    }

    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    public void compose() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompositor(Compositor compositor) {
    }

    public boolean intersects(Bounds point) {
        return false;
    }

    public Glyph getRoot() {
        Glyph root = this;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        return root;
    }

    public Command click() {
        return null;
    }

    public abstract void insert(Glyph glyph, int position) throws GlyphException;

    public abstract void remove(Glyph glyph);

    public abstract Glyph getChild(int position);

    public abstract void adjustCursorAfterComposingChild(Bounds cursor, Bounds bounds);

    public abstract void draw(Window window);

    public abstract void setSize(Window window);

    public Glyph find(int x, int y) {
        Queue<Glyph> queue = new LinkedList<>();
        queue.add(getRoot());
        while (!queue.isEmpty()) {
            Glyph g = queue.remove();
            if (g.intersects(new Bounds(x, y, 0, 0)))
                return g;
            else {
                Iterator iter = g.createIterator();
                while (!iter.isDone()) {
                    queue.add(iter.currentItem());
                    iter.next();
                }
            }
        }
        return null;
    }
}
