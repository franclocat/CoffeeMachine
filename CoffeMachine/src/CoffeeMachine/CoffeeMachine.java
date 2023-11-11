package CoffeeMachine;

import CoffeeTypes.Coffee; // package with self-made Coffee types, getter and setters and constructor for new Coffee types
import java.util.Scanner;

public class CoffeeMachine {
    protected int water;
    protected int milk;
    protected int beans;
    protected int cups;
    protected int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 250, 200, 9, 500);

        for (;;) {
            boolean end = false;
            System.out.println("Write action (buy, fill, take, remaining, exit): "); //prompts the user to input one of the given options
            String action = scanner.next(); //saves the user input for later use
            switch (action) {
                case "buy":
                    machine.buyCoffee(); //asks for a type of coffee or the "back" option and tells you if there are enough ingredients for it
                    break;
                case "fill":
                    machine.fill(); //prompts the user for the amount of each ingredient they want to refill and saves the new amount
                    break;
                case "take":
                    machine.takeMoney(); //prints a message saying how much money was taken out and resets the money counter to 0
                    break;
                case "remaining":
                    machine.getState(); //prints the remaining amount of each ingredient
                    break;
                case "exit": //prints an "exiting" message and makes the end statement true
                    end = true;
                    System.out.println("Exiting the menu...");
                    break;
                default:
                    System.out.println("Wrong input!\n"); //if the input is not one the options given, the system prints "wrong input"
            }
            if (end) { //if true, it ends the program completely
                break;
            }
        }
    }

    /*public void setState() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the starting amount of water in ml:");
        this.water = scanner.nextInt();
        System.out.println("Set the starting amount of milk in ml:");
        this.milk = scanner.nextInt();
        System.out.println("Set the starting amount of beans in grams:");
        this.beans = scanner.nextInt();
        System.out.println("Set the starting amount of disposable cups:");
        this.cups = scanner.nextInt();
    }*/

    public void buyCoffee() {
        Coffee espresso = new Coffee(250, 0, 16, 4);
        Coffee latte = new Coffee(350, 75, 20, 7);
        Coffee cappuccino = new Coffee(200  , 100, 12, 6);

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
            What do you want to buy?
            1 - espresso
            2 - latte
            3 - cappuccino
            back - to main menu
            """);
        String type = scanner.next();

        switch (type) {
            case "1":
                if (this.water - espresso.getNeededWater() < 0) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (this.beans - espresso.getNeededBeans() < 0) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (this.cups - Coffee.neededCups < 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                } else if (this.water - espresso.getNeededWater()>= 0 && espresso.getNeededBeans() >= 0
                        && this.cups - Coffee.neededCups >= 0) {
                    System.out.println("I have enough resources, making you an espresso!\n");
                    this.water -= espresso.getNeededWater();
                    this.beans -= espresso.getNeededBeans();
                    this.cups -= Coffee.neededCups;
                    this.money += espresso.getCost();
                }
                break;

            case "2":
                if (this.water - latte.getNeededWater() < 0) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (this.milk - latte.getNeededMilk() < 0) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (this.beans - latte.getNeededBeans() < 0) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (this.cups - Coffee.neededCups <= 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                } else if (this.water - latte.getNeededWater() >= 0 && this.milk - latte.getNeededMilk() >= 0
                        && this.beans - latte.getNeededBeans() >= 0 && this.cups - Coffee.neededCups >= 0) {
                    System.out.println("I have enough resources, making you a latte!\n");
                    this.water -= latte.getNeededWater();
                    this.milk -= latte.getNeededMilk();
                    this.beans -= latte.getNeededBeans();
                    this.cups -= Coffee.neededCups;
                    this.money += latte.getCost();
                }
                break;

            case "3":
                if (this.water - cappuccino.getNeededWater() >= 0 && this.milk - cappuccino.getNeededMilk() >= 0
                        && this.beans- cappuccino.getNeededBeans() >= 0 && this.cups - Coffee.neededCups >= 0) {
                    System.out.println("I have enough resources, making you a cappuccino!\n");
                    this.water -= cappuccino.getNeededWater();
                    this.milk -= cappuccino.getNeededMilk();
                    this.beans -= cappuccino.getNeededBeans();
                    this.cups -= Coffee.neededCups;
                    this.money += cappuccino.getCost();
                } else if (this.water - cappuccino.getNeededWater() < 0) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (this.milk - cappuccino.getNeededMilk() < 0) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (this.beans - cappuccino.getNeededBeans() < 0) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (this.cups - Coffee.neededCups  <= 0) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                }
                break;

            case "back":
                break;

            default:
                System.out.println("Please select one of the given options\n");
                break;
        }
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        int extraWater = scanner.nextInt();
        this.water += extraWater;

        System.out.println("Write how many ml of milk you want to add:");
        int extraMilk = scanner.nextInt();
        this.milk += extraMilk;

        System.out.println("Write how many grams of coffee beans you want to add:");
        int extraBeans = scanner.nextInt();
        this.beans += extraBeans;

        System.out.println("Write how many disposable cups you want to add:");
        int extraCups = scanner.nextInt();
        this.cups += extraCups;
    }

    public void takeMoney() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    public void getState() {
        System.out.println("The coffee machine has:\n");
        System.out.println(this.water + " ml of water\n" +
                this.milk + " ml of milk\n" +
                this.beans + " g of coffee beans\n" +
                this.cups + " disposable cups\n" +
                "$" + this.money /*+ " of money\n"*/);
    }
}
