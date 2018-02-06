
import glyph.Character;
import glyph.Rectangle;
import window.SwingWindow;

public class Lexi {

    public static void main(String[] args) {
        SwingWindow window = new SwingWindow("title");
        window.setContents(new Character('a', 0, 0));
        window.setContents(new Character('b', 0, 0));
        window.setContents(new Rectangle(0, 0, 100, 100));
    }

}
