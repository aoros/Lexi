
import glyph.Border;
import glyph.Button;
import glyph.Column;
import glyph.Composition;
import glyph.Glyph;
import glyph.GlyphException;
import glyph.Label;
import glyph.Rectangle;
import glyph.Character;
import glyph.Row;
import glyph.Scroller;
import glyph.factory.GUIFactory;
import window.LexiWindow;
import window.Window;

// Composite(163).Client
// Abstract Factory(87).Client
/**
 * Lexi A WYSIWYG document editor
 *
 * I think that we set the compositor on the root Glyph only. Then as each
 * insert on either a Character or Rectangle occurs, it calls the
 * compositor.compose() method. The column and row inserts are just organizing
 * where the characters and rectangles will go.
 */
public class Lexi {

    private static boolean debug = false;

    public static void main(String[] args) throws GlyphException {
        System.out.println(System.getenv("LexiWindow"));
        Window window = new LexiWindow("Lexi");

        try {
            build_hw4_configuration(window);
        } catch (GlyphException ex) {
            System.err.println(ex);
            System.exit(1);
        }
    }

    private static void build_hw4_configuration(Window window) throws GlyphException {

        GUIFactory.getInstance();
        GUIFactory guiFactory = GUIFactory.getGUIFactory();

        Glyph a = new Character('a');
        Glyph rect1 = new Rectangle(10, 20);
        Glyph b = new Character('b');
        Glyph x = new Character('x');
        Glyph y = new Character('y');
        Glyph rect2 = new Rectangle(20, 10);
        Glyph X = new Character('X');
        Glyph Y = new Character('Y');
        Glyph Z = new Character('Z');

        Composition colRoot = new Border(new Scroller(new Column(window)));
        Composition col1 = new Column(window);
        Composition row1 = new Row(window);
        Composition row2 = new Row(window);
        Composition row3 = new Row(window);

        Label label = guiFactory.createLabel(new Row("pq", window));
        Button button = guiFactory.createButton(new Row("PQ", window));

        colRoot.insert(row1, 0);

        row1.insert(a, 0);
        row1.insert(rect1, 1);
        row1.insert(col1, 2);
        col1.insert(X, 0);
        col1.insert(label, 1);
        col1.insert(Z, 2);
        row1.insert(b, 3);

        colRoot.insert(row2, 1);
        row2.insert(x, 0);
        row2.insert(rect2, 1);
        row2.insert(y, 2);

        colRoot.insert(row3, 2);
        row3.insert(button, 0);

        window.setContents(colRoot);
    }
}
