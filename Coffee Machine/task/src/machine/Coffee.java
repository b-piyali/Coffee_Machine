package machine;

public class Coffee {

    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int cost;

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCost() {
        return cost;
    }

    private Coffee(CoffeeBuilder builder) {
        this.coffeeBeans = builder.coffeeBeans;
        this.water = builder.water;
        this.milk = builder.milk;
        this.cost = builder.cost;
    }

    public static class CoffeeBuilder {
        private int water;
        private int milk;
        private final int coffeeBeans;
        private final int cost;

        public CoffeeBuilder(int coffeeBeans, int cost) {
            this.coffeeBeans = coffeeBeans;
            this.cost = cost;
        }

        public CoffeeBuilder setWater(int water) {
            this.water = water;
            return this;
        }

        public CoffeeBuilder setMilk(int milk) {
            this.milk = milk;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

}
