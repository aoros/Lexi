package window;

// AbstractFactory(87): AbstractFactory
// Factory(107): Creator

public class WindowImpFactory {

    private static WindowImp instance;
    private static final String SYS_ENV = System.getenv("LexiWindow");

    private WindowImpFactory() {
    }

    static WindowImp getInstance(String title, Window window) {
        if (instance == null) {
            try {
                switch (SYS_ENV) {
                    case "Swing":
                        instance = new SwingWindow(title, window);
                        break;
                    case "Awt":
                        instance = new AwtWindow(title, window);
                        break;
                    default:
                        instance = new SwingWindow(title, window);
                }
            } catch (Exception ex) {
                instance = new SwingWindow(title, window);
            }
        }

        return instance;
    }

}
