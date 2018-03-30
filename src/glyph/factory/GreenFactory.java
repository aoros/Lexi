// Abstract Factory(87).ConcreteFactory
// Singleton(127).Singleton
// Factory(107).ConcreteCreator
package glyph.factory;

import glyph.Button;
import glyph.Composition;
import glyph.Label;

class GreenFactory extends GUIFactory {

    private GreenFactory() {
    }

    public static GreenFactory getFactoryInstance() {
        return new GreenFactory();
    }

    @Override
    public Button buttonFactoryMethod(Composition composition) {
        return new GreenButton(composition);
    }

    @Override
    public Label labelFactoryMethod(Composition composition) {
        return new GreenLabel(composition);
    }

}
