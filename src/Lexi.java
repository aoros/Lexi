// Composite(163).Client

import glyph.Character;
import glyph.Column;
import glyph.Composition;
import glyph.Glyph;
import glyph.GlyphException;
import glyph.Rectangle;
import glyph.Row;
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

    public static void main(String[] args) {
        Window window = new SwingWindow("Lexi");
        try {
//            build_hw1_configuration(window);
            build_hw2_configuration(window);
//            test_configuration(window);
        } catch (GlyphException ex) {
        }
    }

    private static void test_configuration(Window window) throws GlyphException {
        Glyph ch_a = new Character('a');
        Composition row1 = new Row(window);
        row1.setName("row1");
//        Composition row2_lev_1 = new Row("ghk", window);
        Composition row2 = new Row(window);
        row2.setName("row2");
        Composition row3 = new Row(window);
        row3.setName("row3");
        Glyph ch_g = new Character('g');
        Glyph ch_h = new Character('h');
        Glyph ch_k = new Character('k');

        Composition root = new Row(window);
        root.setName("root");

        root.insert(row1, 0);
        row1.insert(ch_a, 0);
        
        root.insert(row2, 1);
        row2.insert(ch_g, 0);
        row2.insert(ch_h, 1);
        
        root.insert(row3, 2);
        row3.insert(ch_k, 0);

        System.out.println("######################################################");
        root.compose();
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

        Composition root = new Column(window);
        Composition row1_lev_1 = new Row(window);
        Composition row2_lev_1 = new Row(window);
        Composition col1_lev_2 = new Column(window);

        root.insert(row1_lev_1, 0);
        row1_lev_1.insert(ch_a, 0);
        row1_lev_1.insert(rect_A, 1);
        col1_lev_2.insert(ch_X, 0);
        col1_lev_2.insert(ch_Y, 1);
        col1_lev_2.insert(ch_Z, 2);
        row1_lev_1.insert(col1_lev_2, 2);
        row1_lev_1.insert(ch_b, 3);
        root.insert(row2_lev_1, 1);
        row2_lev_1.insert(ch_x, 0);
        row2_lev_1.insert(rect_B, 1);
        row2_lev_1.insert(ch_y, 2);

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
        Composition col1_lev_2 = new Column(window);
        Composition row1_lev_3 = new Row("This is a", window);
        Composition row2_lev_3 = new Row("border demonstration.", window);
        Composition row3_lev_3 = new Row("Scroller too!", window);

        root.insert(row1_lev_1, 0);
        row1_lev_1.insert(ch_a, 0);
        row1_lev_1.insert(rect_A, 1);
        col1_lev_2.insert(row1_lev_3, 0);
        col1_lev_2.insert(row2_lev_3, 1);
        col1_lev_2.insert(row3_lev_3, 2);
        row1_lev_1.insert(col1_lev_2, 2);
        row1_lev_1.insert(ch_b, 3);
        root.insert(row2_lev_1, 1);
        row2_lev_1.insert(ch_x, 0);
        row2_lev_1.insert(rect_B, 1);
        row2_lev_1.insert(ch_y, 2);

        window.setContents(root);
    }
}
