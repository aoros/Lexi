package glyph.factory;

import glyph.Button;
import glyph.Composition;
import glyph.Label;

// Abstract Factory(87).ConcreteFactory
// Singleton(127).Singleton
// Factory(107).ConcreteCreator
class RedFactory extends GUIFactory {

    private RedFactory() {
    }

    protected static GUIFactory getFactoryInstance() {
        return new RedFactory();
    }

    @Override
    public Button buttonFactoryMethod(Composition composition) {
        return new RedButton(composition);
    }

    @Override
    public Label labelFactoryMethod(Composition composition) {
        return new RedLabel(composition);
    }
}
