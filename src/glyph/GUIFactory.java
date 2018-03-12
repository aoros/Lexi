package glyph;

public abstract class GUIFactory {

    private static GUIFactory instance;
    private static final String SYS_ENV = System.getenv("LexiWidget");

    protected GUIFactory() {
    }

    public static GUIFactory getInstance() {
        if (instance == null) {
            if (SYS_ENV != null && SYS_ENV.equals("Green"))
                return GreenFactory.getInstance();
            else
                return RedFactory.getInstance();
        }
        return instance;
    }

    protected Label labelFactoryMethod(String text) {
        if (SYS_ENV != null && SYS_ENV.equals("Green"))
            return GreenFactory.getInstance().createLabel(text);
        else
            return RedFactory.getInstance().createLabel(text);
    }

    protected Button buttonFactoryMethod(String text) {
        String sys_env = System.getenv("LexiWidget");
        if (sys_env != null && sys_env.equals("Green"))
            return GreenFactory.getInstance().createButton(text);
        else
            return RedFactory.getInstance().createButton(text);
    }

    public Button createButton(String text) {
        return buttonFactoryMethod(text);

    }

    public Label createLabel(String text) {
        return labelFactoryMethod(text);
    }
}
