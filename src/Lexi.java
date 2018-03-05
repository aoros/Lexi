// Composite(163).Client

import glyph.Border;
import glyph.Character;
import glyph.Column;
import glyph.Composition;
import glyph.Glyph;
import glyph.GlyphException;
import glyph.Rectangle;
import glyph.Row;
import glyph.Scroller;
import java.util.LinkedList;
import java.util.Queue;
import window.SwingWindow;
import window.Window;

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

    public static void main(String[] args) {
        Window window = new SwingWindow("Lexi");
        window.setDebug(debug);
        try {
//            build_hw1_configuration(window);
//            build_hw2_configuration(window);

            test_configuration_simple(window);
//            test_configuration_rows(window);
//            test_configuration_cols(window);
        } catch (GlyphException ex) {
            System.err.println(ex);
            System.exit(1);
        }
    }

    private static void test_configuration_simple(Window window) throws GlyphException {
        Glyph root = new Column(window, "root");
        Glyph row = new Scroller(new Row(window, "row"));
//        Glyph row2 = new Row(window, "row2");

//        root.insert(row1, 0);
        row.insert(new Scroller(new Character('a')), 0);
        row.insert(new Character('b'), 1);
        debug = true;
        window.setDebug(debug);
        root.insert(row, 0);

        printLexiTree(root);

//        root.insert(new Character('b'), 1);
//        root.insert(row2, 1);
//        row1.insert(new Character('c'), 0);
//        row1.insert(new Character('d'), 1);
        window.setContents(root);
    }

    private static void test_configuration_rows(Window window) throws GlyphException {
        Glyph ch_a = new Character('a');
        Glyph ch_m = new Character('m');
        Composition root = new Row(window, "root");
        Composition row1 = new Row(window, "row1");
        /////////////////////////////////////////////////////////////
//		Glyph row2 = new Row("ghk", window, "row2");
        Glyph row2 = new Scroller(new Row("ghk", window, "row2"));
//		Glyph row2 = new Border(new Row("ghk", window, "row2"));
//        Glyph row2 = new Border(new Scroller(new Row("ghk", window, "row2")));
        /////////////////////////////////////////////////////////////        
        Composition row3 = new Row(window, "row3");

        // insert into the glyph tree
        insert(root, row1, 0);
        insert(row1, ch_a, 0);
        insert(root, row2, 1);
        insert(root, row3, 2);
        insert(row3, ch_m, 0);

        root.compose();
        window.setContents(root);
    }

    private static void test_configuration_cols(Window window) throws GlyphException {
        Glyph ch_a = new Character('a');
        Glyph ch_m = new Character('m');
        Composition root = new Column(window, "root");
        Composition col1 = new Column(window, "row1");
        String[] arr = new String[1];
        arr[0] = "ghk";
        Glyph col2 = new Scroller(new Border(new Column(arr, window, "row2")));
//        Composition row2 = new Row("ghk", window, "row2");
        Composition col3 = new Column(window, "row3");

        // insert into the glyph tree
        insert(root, col1, 0);
        insert(col1, ch_a, 0);
        insert(root, col2, 1);
        insert(root, col3, 2);
        insert(col3, ch_m, 0);

        window.setContents(root);
    }

    private static void build_hw1_configuration(Window window) throws GlyphException {
        Glyph ch_a = new Character('a');
        Glyph rect_A = new Rectangle(10, 20);
        Glyph ch_X = new Character('X');
        Glyph ch_Y = new Character('Y');
        Glyph ch_Z = new Character('Z');
        Glyph ch_b = new Character('b');
        Glyph ch_x = new Character('x');
        Glyph ch_y = new Character('y');
        Glyph rect_B = new Rectangle(20, 10);

        Composition root = new Column(window, "root");
        Composition row1_lev_1 = new Row(window, "row1_lev_1");
        Composition row2_lev_1 = new Row(window, "row2_lev_1");
        Composition col1_lev_2 = new Column(window, "col1_lev_2");

        insert(root, row1_lev_1, 0);
        insert(row1_lev_1, ch_a, 0);
        insert(row1_lev_1, rect_A, 1);
        insert(row1_lev_1, col1_lev_2, 2);
        insert(col1_lev_2, ch_X, 0);
        insert(col1_lev_2, ch_Y, 1);
        insert(col1_lev_2, ch_Z, 2);
        insert(row1_lev_1, ch_b, 3);
        insert(root, row2_lev_1, 1);
        insert(row2_lev_1, ch_x, 0);
        insert(row2_lev_1, rect_B, 1);
        insert(row2_lev_1, ch_y, 2);

        debug = true;
        printLexiTree(root);
        
        window.setContents(root);
    }

    private static void build_hw2_configuration(Window window) throws GlyphException {
        Glyph ch_a = new Character('a');
        Glyph rect_A = new Rectangle(10, 20);
        Glyph ch_b = new Character('b');
        Glyph ch_x = new Character('x');
        Glyph ch_y = new Character('y');
        Glyph rect_B = new Rectangle(20, 10);

        Composition root = new Column(window);
        Composition row1_lev_1 = new Row(window);
        Composition row2_lev_1 = new Row(window);
        Glyph col1_lev_2 = new Scroller(new Border(new Column(window)));
        Composition row1_lev_3 = new Row("This is a", window);
        Composition row2_lev_3 = new Row("border demonstration.", window);
        Composition row3_lev_3 = new Row("Scroller too!", window);

        insert(root, row1_lev_1, 0);
        insert(row1_lev_1, ch_a, 0);
        insert(row1_lev_1, rect_A, 1);
        insert(col1_lev_2, row1_lev_3, 0);
        insert(col1_lev_2, row2_lev_3, 1);
        insert(col1_lev_2, row3_lev_3, 2);
        insert(row1_lev_1, col1_lev_2, 2);
        insert(row1_lev_1, ch_b, 3);
        insert(root, row2_lev_1, 1);
        insert(row2_lev_1, ch_x, 0);
        insert(row2_lev_1, rect_B, 1);
        insert(row2_lev_1, ch_y, 2);

        window.setContents(root);
    }

    private static void insert(Glyph parent, Glyph child, int i) throws GlyphException {
        parent.insert(child, i);
    }

    public static void printLexiTree(Glyph glyph) throws GlyphException {
        if (debug) {
            System.out.println("===================================================");
            Glyph root = glyph.getRoot();
            Queue<Glyph> queue = new LinkedList<>();
            queue.add(root);

            String spaces = "";
            while (!queue.isEmpty()) {
                Glyph g = queue.remove();
                Glyph child;
                try {
                    for (int i = 0; (child = g.getChild(i)) != null; i++) {
                        queue.add(child);
                    }
                } catch (Exception ex) {
                }
                System.out.println(spaces + g.toString());
                spaces += " ";
            }
            System.out.println("===================================================");
        }
    }
}
