package compositor;


import glyph.Glyph;
import java.awt.FontMetrics;
import javax.swing.JFrame;
import window.Window;

public class FakeSwingWindow implements Window {

    private final JFrame _jFrame;
    private final FontMetrics _fm;

    public FakeSwingWindow() {
        _jFrame = new JFrame();
        _jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _jFrame.setVisible(false);
        _fm = _jFrame.getGraphics().getFontMetrics();
    }

    @Override
    public void drawCharacter(char c, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int charWidth(char c) {
        return _fm.charWidth(c);
    }

    @Override
    public int charHeight(char c) {
        return _fm.getHeight();
    }

    @Override
    public void setContents(Glyph glyph) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addBorder(int x1, int y1, int x2, int y2, int width) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addScrollBar(int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
