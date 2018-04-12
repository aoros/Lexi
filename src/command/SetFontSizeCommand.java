package command;

import glyph.ActionType;
import glyph.Glyph;
import java.util.Objects;
import window.Window;

public class SetFontSizeCommand implements Command, Cloneable {

    Glyph _glyph;
    Window _window;
    ActionType _actionType;
    int _previousFontSize;
    boolean hasBeenExecuted = false;

    public SetFontSizeCommand(Glyph _glyph, Window _window, ActionType actionType, int previousFontSize) {
        this._glyph = _glyph;
        this._window = _window;
        this._actionType = actionType;
        this._previousFontSize = previousFontSize;
    }

    public SetFontSizeCommand(Window _window, ActionType actionType) {
        this(null, _window, actionType, 0);
    }

    private SetFontSizeCommand(SetFontSizeCommand clone) {
        this(clone._glyph, clone._window, clone._actionType, clone._previousFontSize);
    }

    @Override
    public void setGlyph(Glyph _glyph) {
        this._glyph = _glyph;
    }

    @Override
    public void execute() {
        _previousFontSize = _window.getFontSize();
        setFontSize();
        CommandHistory.getInstance().add(this);
        System.out.println(CommandHistory.getInstance().toString());
    }

    private void setFontSize() {
        if (_actionType != null) {
            if (null != _actionType) {
                switch (_actionType) {
                    case INCR_FONT_SIZE_BY_1:
                        _window.setFontSize(_window.getFontSize() + 1);
                        break;
                    case DECR_FONT_SIZE_BY_1:
                        _window.setFontSize(_window.getFontSize() - 1);
                        break;
                    case SET_FONT_SIZE_TO_14:
                        _window.setFontSize(14);
                        break;
                    case SET_FONT_SIZE_TO_20:
                        _window.setFontSize(20);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void unexecute() {
        _window.setFontSize(_previousFontSize);
    }

    @Override
    public Command clone() {
        Command copy = null;
        try {
            copy = new SetFontSizeCommand((SetFontSizeCommand) super.clone());
//            copy = (SetFontSizeCommand) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return copy;
    }

    @Override
    public Glyph getGlyph() {
        return _glyph;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this._glyph);
        hash = 79 * hash + Objects.hashCode(this._window);
        hash = 79 * hash + Objects.hashCode(this._actionType);
        hash = 79 * hash + this._previousFontSize;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SetFontSizeCommand other = (SetFontSizeCommand) obj;
        return true;
    }

    @Override
    public String toString() {
        return "SetFontSizeCommand{" + _actionType + '}';
    }
}
