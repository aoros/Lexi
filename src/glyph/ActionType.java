package glyph;

public enum ActionType {
    INCR_FONT_SIZE_BY_1(" + ", 1),
    DECR_FONT_SIZE_BY_1(" - ", 1),
    SET_FONT_SIZE_TO_14(" 14 ", 14),
    SET_FONT_SIZE_TO_20(" 20 ", 20),;

    private final String actionType;
    private final int actionValue;

    ActionType(String actionType, int actionValue) {
        this.actionType = actionType;
        this.actionValue = actionValue;
    }

    public String getActionType() {
        return actionType;
    }

    public int getActionValue() {
        return actionValue;
    }
}
