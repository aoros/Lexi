// Strategy(315).Strategy
package compositor;

import glyph.Composition;
import window.Window;

public interface Compositor {

    void setComposition(Composition composition);
    
    public void setWindow(Window window);

    void compose();
}
