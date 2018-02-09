package compositor;

import glyph.Composition;

public class SimpleCompositor implements Compositor {

    private Composition composition;

    public SimpleCompositor() {
    }
    

    @Override
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public void compose() {
        
    }

}
