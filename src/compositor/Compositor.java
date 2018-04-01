package compositor;

import glyph.Composition;
import window.Window;

// Strategy(315).Strategy
public interface Compositor {

    void setComposition(Composition composition);

    public void setWindow(Window window);

    void compose();
}
