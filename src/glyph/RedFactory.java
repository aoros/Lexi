package glyph;

public class RedFactory extends GUIFactory {

    private static RedFactory _instance;

    private RedFactory() {
    }

    public static RedFactory getInstance() {
        if (_instance == null)
            return new RedFactory();

        return _instance;
    }

    @Override
    public Label createLabel(String text) {
        return new RedLabel(text);
    }

    @Override
    public Button createButton(String text) {
        return new RedButton(text);
    }

}
