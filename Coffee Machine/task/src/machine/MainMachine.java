package machine;

public class MainMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int dCups;
    private int money;

    public MainMachine(int water, int milk, int coffeeBeans, int dCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.dCups = dCups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getDCups() {
        return dCups;
    }

    public void setDCups(int dCups) {
        this.dCups = dCups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
