package glyph.factory;

import glyph.Button;
import glyph.ActionType;
import glyph.Composition;
import glyph.Label;

// Abstract Factory(87).ConcreteFactory
// Singleton(127).Singleton
// Factory(107).ConcreteCreator
class GreenFactory extends GUIFactory {

    private GreenFactory() {
    }

    public static GreenFactory getFactoryInstance() {
        return new GreenFactory();
    }

    @Override
    public Button buttonFactoryMethod(Composition composition) {
        return new GreenButton(composition, null);
    }

    @Override
    public Label labelFactoryMethod(Composition composition) {
        return new GreenLabel(composition);
    }

    @Override
    protected Button buttonFactoryMethod(Composition composition, ActionType actionType) {
        return new GreenButton(composition, actionType);
    }

}
