package window;

import command.Command;
import glyph.Glyph;

// Bridge(151): RefinedAbstraction
public class LexiWindow extends Window {

    private Glyph _glyph;

    public LexiWindow(String title) {
        super(title);
    }

    @Override
    public void setContents(Glyph glyph) {
        _glyph = glyph;
        _windowImp.setContents();
    }

    @Override
    public void draw() {
        if (_glyph != null)
            _glyph.draw(this);
    }

    @Override
    public void key(char keyChar) {
        System.out.println("the keyChar is " + keyChar);
    }

    @Override
    public void click(int x, int y) {
        Glyph root = _glyph.getRoot();
        if (root != null) {
            Glyph selectedGlyph = root.find(x, y);
            if (selectedGlyph != null) {
                Command c = selectedGlyph.click();
                c.execute();
                root.compose();
                setContents(root);
            }
            System.out.println(selectedGlyph);
        }

        System.out.println("the click x=" + x + " and y=" + y);
    }
}
