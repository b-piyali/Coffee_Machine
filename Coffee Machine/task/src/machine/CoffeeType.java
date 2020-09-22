package machine;

public enum CoffeeType {
    ESPRESSO("1"),
    LATTE("2"),
    CAPPUCCINO("3"),
    BACK("back");

    private final String type;

    CoffeeType(String type) {
        this.type = type;
    }

    public String getCoffeeType() {
        return this.type;
    }

    public static CoffeeType findByCoffeeType(String type) {
        for (CoffeeType value : values()) {
            if (type.equals(value.type)) {
                return value;
            }
        }
        return null;
    }

}
