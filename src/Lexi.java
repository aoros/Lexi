// Composite(163).Client

import compositor.SimpleCompositor;
import glyph.Character;
import glyph.Column;
import glyph.Composition;
import glyph.Rectangle;
import glyph.Row;
import window.SwingWindow;

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
        SwingWindow window = new SwingWindow("Lexi");

        // 
        Composition root = new Column();
        root.setCompositor(new SimpleCompositor(window));

        // Create row 1
        Composition row1 = new Row();
        row1.setCompositor(new SimpleCompositor(window));
        
        root.insert(row1, 0);
        // Add a character and a rectangle
        row1.insert(new Character('a'), 0);
        row1.insert(new Rectangle(10, 20), 1);
        
        // Create a column in row 1
        Composition row1_col = new Column();
        row1_col.setCompositor(new SimpleCompositor(window));
        // Add 3 characters to the column
        row1_col.insert(new Character('X'), 0);
        row1_col.insert(new Character('Y'), 1);
        row1_col.insert(new Character('Z'), 2);
        // Add column to row 1
        row1.insert(row1_col, 2);
        // Add character to row 1
        row1.insert(new Character('b'), 3);

        // Create row 2
        Composition row2 = new Row();
        row2.setCompositor(new SimpleCompositor(window));
        
        root.insert(row2, 1);
        // Add 2 characters and a rectangle to row 2
        row2.insert(new Character('x'), 0);
        row2.insert(new Rectangle(20, 10), 1);
        row2.insert(new Character('y'), 2);

        // At this point, the glyphs should be drawn on the SwingWindow
        window.setContents(root);
    }

}
