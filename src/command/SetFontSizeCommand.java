package command;

import glyph.ActionType;
import glyph.Glyph;
import window.Window;

public class SetFontSizeCommand implements Command {

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
        return new SetFontSizeCommand(this);
    }

    @Override
    public Glyph getGlyph() {
        return _glyph;
    }
}
