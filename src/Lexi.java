
import command.PrintWordsCommand;
import command.KeyMap;
import command.RedoCommand;
import command.SetFontSizeCommand;
import command.UndoCommand;
import glyph.ActionType;
import glyph.Border;
import glyph.Button;
import glyph.Character;
import glyph.Column;
import glyph.Composition;
import glyph.Glyph;
import glyph.GlyphException;
import glyph.Label;
import glyph.Rectangle;
import glyph.Row;
import glyph.Scroller;
import glyph.factory.GUIFactory;
import window.LexiWindow;
import window.Window;

// Composite(163).Client
// Abstract Factory(87).Client
// Command(233).Client
public class Lexi {

    private static final KeyMap KEY_MAP = new KeyMap();

    public static void main(String[] args) throws GlyphException {
        Window window = new LexiWindow("Lexi");

        try {
            build_hw6_configuration(window);
        } catch (GlyphException ex) {
            System.err.println(ex);
            System.exit(1);
        }
    }

    private static void build_hw6_configuration(Window window) throws GlyphException {
        GUIFactory.getInstance();
        GUIFactory guiFactory = GUIFactory.getGUIFactory();

        Composition colRoot = new Column(window);
        Glyph a = new Row("Word Up Yo!", window);
        Glyph b = new Row("Another Line 1", window);
        Glyph c = new Row("Another Line 2", window);
        Glyph d = new Row("Yet Another Line 3", window);
        Label label = guiFactory.createLabel(new Row("pq", window));
        Button pq_button = guiFactory.createButton(new Row("PQ", window));
        Glyph rect = new Rectangle(10, 20);

        colRoot.insert(a, 0);
        colRoot.insert(label, 1);
        colRoot.insert(b, 2);
        colRoot.insert(pq_button, 3);
        colRoot.insert(c, 4);
        colRoot.insert(rect, 5);
        colRoot.insert(d, 6);

        KEY_MAP.put('i', new SetFontSizeCommand(colRoot, window, ActionType.INCR_FONT_SIZE_BY_1, 0));
        KEY_MAP.put('d', new SetFontSizeCommand(colRoot, window, ActionType.DECR_FONT_SIZE_BY_1, 0));
        KEY_MAP.put('u', new UndoCommand(colRoot, window));
        KEY_MAP.put('r', new RedoCommand(colRoot, window));
        KEY_MAP.put('w', new PrintWordsCommand(colRoot, window));

        window.setKeyMap(KEY_MAP);
        window.setContents(colRoot);
    }

    private static void build_hw5_configuration(Window window) throws GlyphException {
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
        Composition row4 = new Row(window);

        Label label = guiFactory.createLabel(new Row("pq", window));

        Button pq_button = guiFactory.createButton(new Row("PQ", window));
        Button plus_button = guiFactory.createButton(new Row(" + ", window), new SetFontSizeCommand(window, ActionType.INCR_FONT_SIZE_BY_1));
        Button minus_button = guiFactory.createButton(new Row(" - ", window), new SetFontSizeCommand(window, ActionType.DECR_FONT_SIZE_BY_1));
        Button s14_button = guiFactory.createButton(new Row(" 14 ", window), new SetFontSizeCommand(window, ActionType.SET_FONT_SIZE_TO_14));
        Button s20_button = guiFactory.createButton(new Row(" 20 ", window), new SetFontSizeCommand(window, ActionType.SET_FONT_SIZE_TO_20));

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
        row3.insert(pq_button, 0);

        colRoot.insert(row4, 3);
        row4.insert(plus_button, 0);
        row4.insert(minus_button, 1);
        row4.insert(s14_button, 2);
        row4.insert(s20_button, 3);

        KEY_MAP.put('i', new SetFontSizeCommand(colRoot, window, ActionType.INCR_FONT_SIZE_BY_1, 0));
        KEY_MAP.put('d', new SetFontSizeCommand(colRoot, window, ActionType.DECR_FONT_SIZE_BY_1, 0));
        KEY_MAP.put('u', new UndoCommand(colRoot, window));
        KEY_MAP.put('r', new RedoCommand(colRoot, window));
        KEY_MAP.put('w', new PrintWordsCommand(colRoot, window));

        window.setKeyMap(KEY_MAP);
        window.setContents(colRoot);
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
