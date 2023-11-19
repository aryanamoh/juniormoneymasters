public class Player {
    private String name;
    private int points;
    private double budgetAmount, debt, food, clothes, gas, savings, misc;
    private boolean hasCreditCard;

    public Player (String name, int points, double budgetAmount, double debt, double food, double clothes, double gas, double savings, double misc, boolean hasCreditCard){
        this.name = name;
        this.points = points;
        this.budgetAmount = budgetAmount;
        this.debt = debt;
        this.food = food;
        this.clothes = clothes;
        this.gas = gas;
        this.savings = savings;
        this.misc = misc;
        this.hasCreditCard = hasCreditCard;
    }

    public Player (String name, double budgetAmount) {
        this.name = name;
        this.budgetAmount = budgetAmount;
        this.points = 0;
        this.debt = 0;
        this.food = 0;
        this.clothes = 0;
        this.gas = 0;
        this.savings = 0;
        this.misc = 0;
        this.hasCreditCard = false;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public double getDebt() {
        return debt;
    }

    public double getFood() {
        return food;
    }

    public double getClothes() {
        return clothes;
    }

    public double getGas() {
        return gas;
    }

    public double getSavings() {
        return savings;
    }

    public double getMisc() {
        return misc;
    }

    public boolean getHasCreditCard() {
        return hasCreditCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public void setClothes(double clothes) {
        this.clothes = clothes;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public void setMisc(double misc) {
        this.misc = misc;
    }

    public void setHasCreditCard(boolean hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }

    public double gainInterest() {
        double interestEarned = savings * .043;
        interestEarned = Math.round(interestEarned * 100) / 100;
        savings += interestEarned;
        return interestEarned;
    }

    public double getCashback(String spendingType, double amt) {
        double cashBackEarned;
        if (spendingType.equals("food") || spendingType.equals("entertainment")) {
            cashBackEarned = amt * .03;
        } else {
            cashBackEarned = amt * .01;
        }
        cashBackEarned = Math.round(cashBackEarned*100) / 100;
        budgetAmount += cashBackEarned;
        return cashBackEarned;
    }

    public void cardBonus() {
        budgetAmount += 50;
    }

    public void accumulateDebt() {
        debt += debt * .2;
        debt = Math.round(debt * 100) / 100;
    }

    public String toString() {
        String ret = "";
        ret += "Name: " + name + "\n";
        ret += "Points: " + points + "\n";
        ret += "You have $" + budgetAmount + " left \n";
        ret += "You have $" + debt + " of credit card debt, ";
        if (debt == 0.0) {
            ret += "good job \n";
        } else {
            ret += "bad job \n";
        }
        ret += "You spent $" + food + " on food, $" + clothes + " on clothes, $" + gas + " on gas, saved $" + savings + ", and spent $" + misc + " on miscellaneous items";
        return ret;
    }


    public static void main(String[] args) {
        Player player1 = new Player("Liam", 100.0);
        System.out.println(player1);
    }
}
