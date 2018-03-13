// Abstract Factory(87).ConcreteFactory
// Singleton(127).Singleton
// Factory(107).ConcreteCreator
package glyph.factory;

import glyph.Button;
import glyph.GreenButton;
import glyph.GreenLabel;
import glyph.Label;

public class GreenFactory extends GUIFactory {

    private static GreenFactory _instance;

    private GreenFactory() {
    }

    public static GreenFactory getInstance() {
        if (_instance == null)
            return new GreenFactory();

        return _instance;
    }

    @Override
    public Label createLabel(String text) {
        return new GreenLabel(text);
    }

    @Override
    public Button createButton(String text) {
        return new GreenButton(text);
    }

}
