package command;

import glyph.ActionType;
import glyph.Glyph;
import window.Window;

public class SetFontSizeCommand implements Command {

    private Glyph _glyph;
    private Window _window;
    private ActionType _actionType;

    public SetFontSizeCommand(Glyph _glyph, Window _window, ActionType actionType) {
        this._glyph = _glyph;
        this._window = _window;
        this._actionType = actionType;
    }

    public SetFontSizeCommand(Window _window) {
        this._glyph = null;
        this._window = _window;
    }

    @Override
    public void execute() {
        if (_actionType != null) {
            if (null != _actionType) switch (_actionType) {
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

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Command clone() {
        Command copy = null;
        try {
            copy = (SetFontSizeCommand) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return copy;
    }
}
