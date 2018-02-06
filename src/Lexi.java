
import glyph.Character;
import glyph.Rect;
import glyph.Rectangle;
import window.SwingWindow;

public class Lexi {

    public static void main(String[] args) {
        SwingWindow window = new SwingWindow("Lexi");

        window.setContents(new Character(null, 'a', new Rect(0, 0, window.charHeight('a'), window.charWidth('a'))));
        window.setContents(new Rectangle(null, new Rect(0, 0, 10, 20)));
    }

}
