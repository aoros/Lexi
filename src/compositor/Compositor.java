// Strategy(315).Strategy
package compositor;

import glyph.Composition;
import window.Window;

public interface Compositor {

    void setComposition(Composition composition);

    void compose();

    void setWindow(Window window);
}
