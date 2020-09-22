package machine;

import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        MainMachine machine = new MainMachine(400, 540, 120, 9, 550);
        //greet();
        //initialInformation(machine);
        //System.out.println();
        coffeeMachine.performAction(machine);
    }


    private static void greet() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    private static void initialInformation(MainMachine machine) {
        System.out.println("The coffee machine has:");
        System.out.println(machine.getWater() + " of water");
        System.out.println(machine.getMilk() + " of milk");
        System.out.println(machine.getCoffeeBeans() + " of coffee beans");
        System.out.println(machine.getDCups() + " of disposable cups");
        if (machine.getMoney() > 0) {
            System.out.println("$" + machine.getMoney() + " of money");
        } else {
            System.out.println(machine.getMoney() + " of money");
        }
    }

    private void performAction(MainMachine machine) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String inputAction = scanner.next();
        Action action = Action.findByAction(inputAction);

        while (action != Action.EXIT) {
            switch (Objects.requireNonNull(action)) {
                case BUY:
                    performBuy(machine);
                    break;
                case FILL:
                    performFill(machine);
                    break;
                case TAKE:
                    performTake(machine);
                    break;
                case REMAINING:
                    System.out.println();
                    initialInformation(machine);
                    break;
                default:
                    break;
            }
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            inputAction = scanner.next();
            action = Action.findByAction(inputAction);
        }
    }

    private void performTake(MainMachine machine) {
        System.out.println("I gave you $" + machine.getMoney());
        machine.setMoney(0);
    }

    private void performFill(MainMachine machine) {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int dCups = scanner.nextInt();
        machine.setWater(machine.getWater() + water);
        machine.setCoffeeBeans(machine.getCoffeeBeans() + beans);
        machine.setMilk(machine.getMilk() + milk);
        machine.setDCups(machine.getDCups() + dCups);
    }

    private void performBuy(MainMachine machine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String type = scanner.next();
        CoffeeType coffeeType = CoffeeType.findByCoffeeType(type);

        switch (Objects.requireNonNull(coffeeType)) {
            case ESPRESSO:
                buildEspresso(machine);
                break;
            case LATTE:
                buildLatte(machine);
                break;
            case CAPPUCCINO:
                buildCappuccino(machine);
                break;
            case BACK:
            default:
                break;
        }
    }

    private void buildEspresso(MainMachine machine) {
        Coffee espresso = new Coffee.CoffeeBuilder(16, 4).setWater(250).build();
        remainItem(machine, espresso);
    }


    private void buildLatte(MainMachine machine) {
        Coffee latte = new Coffee.CoffeeBuilder(20, 7).setWater(350).setMilk(75).build();
        remainItem(machine, latte);
    }

    private void buildCappuccino(MainMachine machine) {
        Coffee cappuccino = new Coffee.CoffeeBuilder(12, 6).setWater(200).setMilk(100).build();
        remainItem(machine, cappuccino);
    }

    private void remainItem(MainMachine machine, Coffee coffee) {
        if (machine.getWater() >= coffee.getWater() &&
                machine.getCoffeeBeans() >= coffee.getCoffeeBeans() &&
                machine.getMilk() >= coffee.getMilk() &&
                machine.getDCups() > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            machine.setWater(machine.getWater() - coffee.getWater());
            machine.setCoffeeBeans(machine.getCoffeeBeans() - coffee.getCoffeeBeans());
            machine.setMoney(machine.getMoney() + coffee.getCost());
            machine.setMilk(machine.getMilk() - coffee.getMilk());
            machine.setDCups(machine.getDCups() - 1);
        } else if (machine.getWater() < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (machine.getMilk() < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (machine.getCoffeeBeans() < coffee.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

}
