package machine;

public enum Action {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }

    public static Action findByAction(String action) {
        for (Action value : values()) {
            if (action.equals(value.action)) {
                return value;
            }
        }
        return null;
    }
}
