
import glyph.Bounds;
import glyph.Rectangle;
import window.SwingWindow;

public class Lexi {

    public static void main(String[] args) {
        SwingWindow window = new SwingWindow("Lexi");

//        window.setContents(new Character(null, 'a', new Bounds(0, 0, window.charHeight('a'), window.charWidth('a'))));
        window.setContents(new Rectangle(null, new Bounds(0, 0, 10, 20)));
    }

}
