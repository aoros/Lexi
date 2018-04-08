package glyph.factory;

import glyph.Button;
import glyph.ActionType;
import glyph.Composition;
import glyph.Label;

// Abstract Factory(87).AbstractFactory
// Factory(107).Creator
public abstract class GUIFactory {

    private static GUIFactory instance;
    private static final String SYS_ENV = System.getenv("LexiWidget");

    protected GUIFactory() {
    }

    public static void getInstance() {
        try {
            switch (SYS_ENV) {
                case "red":
                    instance = RedFactory.getFactoryInstance();
                    break;
                case "green":
                    instance = GreenFactory.getFactoryInstance();
                    break;
                default:
                    instance = RedFactory.getFactoryInstance();
            }
        } catch (Exception ex) {
            instance = RedFactory.getFactoryInstance();
        }
    }

    public static GUIFactory getGUIFactory() {
        return instance;
    }

    public final Button createButton(Composition composition) {
        return buttonFactoryMethod(composition);
    }

    public final Button createButton(Composition composition, ActionType actionType) {
        return buttonFactoryMethod(composition, actionType);
    }

    public final Label createLabel(Composition composition) {
        return labelFactoryMethod(composition);
    }

    protected abstract Label labelFactoryMethod(Composition composition);

    protected abstract Button buttonFactoryMethod(Composition composition);
    
    protected abstract Button buttonFactoryMethod(Composition composition, ActionType actionType);
}
