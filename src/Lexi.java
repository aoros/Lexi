
import compositor.Compositor;
import compositor.SimpleCompositor;
import glyph.Character;
import glyph.Column;
import glyph.Composition;
import glyph.Glyph;
import glyph.Rectangle;
import glyph.Row;
import window.SwingWindow;

public class Lexi {

    public static void main(String[] args) {
        SwingWindow window = new SwingWindow("Lexi");

        Composition root = new Column();
        Composition row1 = new Row();
        Composition row2 = new Row();
        Composition col = new Column();

        Glyph a = new Character('a');
        Glyph rect1 = new Rectangle(10, 20);
        Glyph _X = new Character('X');
        Glyph _Y = new Character('Y');
        Glyph _Z = new Character('Z');
        Glyph b = new Character('b');
        Glyph rect2 = new Rectangle(20, 10);
        Glyph _x = new Character('x');
        Glyph _y = new Character('y');

        // Level 1
        root.insert(row1, 0);
        root.insert(row2, 1);

        // Level 2
        row1.insert(a, 0);
        row1.insert(rect1, 1);
        row1.insert(col, 2);
        row1.insert(b, 3);
        row2.insert(_x, 0);
        row2.insert(rect2, 1);
        row2.insert(_y, 2);

        // Level 3
        col.insert(_X, 0);
        col.insert(_Y, 1);
        col.insert(_Z, 2);

        Compositor compositor = new SimpleCompositor(window);
        compositor.setComposition(root);
        compositor.compose();
    }

}
