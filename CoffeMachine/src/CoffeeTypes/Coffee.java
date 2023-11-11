package CoffeeTypes;

public class Coffee {
    protected int neededWater;
    protected int neededMilk;
    protected int neededBeans;
    protected int cost;
    public final static int neededCups = 1;

    public Coffee(int neededWater, int neededMilk, int neededBeans, int cost) {
        this.neededWater = neededWater;
        this.neededMilk = neededMilk;
        this.neededBeans = neededBeans;
        this.cost = cost;
    }

    public void setNeededWater(int neededWater) {
        this.neededWater = neededWater;
    }
    public int getNeededWater() {
        return this.neededWater;
    }

    public void setNeededMilk(int neededMilk) {
        this.neededMilk = neededMilk;
    }
    public int getNeededMilk() {
        return this.neededMilk;
    }

    public void setNeededBeans(int neededBeans) {
        this.neededBeans = neededBeans;
    }
    public int getNeededBeans() {
        return this.neededBeans;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getCost() {
        return this.cost;
    }

}
