package window;

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
}
