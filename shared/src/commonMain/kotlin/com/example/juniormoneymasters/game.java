
import java.util.Scanner;

public class game {
    private class Choice {
        private String option;
        private int cost;
        private int points;
        private String type;

        public Choice(String option, int cost, int points, String type) {
            this.option = option;
            this.cost = cost;
            this.points = points;
            this.type = type;
        }

        public static void updateCategory(Player player, Choice opt) {
            if (opt.type.equals("debt")) {
                player.setDebt(player.getDebt() + opt.cost);
            } else if (opt.type.equals("food")) {
                player.setFood(player.getFood() + opt.cost);
            } else if (opt.type.equals("clothes")) {
                player.setClothes(player.getClothes() + opt.cost);
            } else if (opt.type.equals("misc")) {
                player.setMisc(player.getMisc() + opt.cost);
            } else if (opt.type.equals("gas")) {
                player.setGas(player.getGas() + opt.cost);
            } else {
                player.setSavings(player.getSavings() + opt.cost);
            }
        }
        public static void compareChoices(Player player, Choice[] arr) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have "+ arr.length + " options: ");
            for (Choice opt: arr) {
                System.out.println(opt.option + " ($" + opt.cost + ")");
            }

            System.out.print("type the option you want to choose: ");
            String inOption = scanner.nextLine();
            int count = 1;

            for (Choice opt: arr) {
                if (opt.option.equals(inOption) || Integer.valueOf(inOption) == count) {
                    System.out.println("You chose: " + opt.option);
                    player.setBudgetAmount(player.getBudgetAmount() - opt.cost);
                    if (player.getHasCreditCard()) {
                        double cashBack = player.getCashback(opt.type, opt.cost);
                        System.out.println("You earned $" + cashBack + " in cash back from this purchase");
                    }
                    updateCategory(player, opt);
                    player.setPoints(player.getPoints() + opt.points);
                    System.out.println("You have $" + player.getBudgetAmount() + " left and you got " + opt.points + " additional points");
                    System.out.println();
                }

                count++;
            }
        }
    }
    public static void main(String[] args) {
        // Create a new instance of the Game class
        game round1 = new game();

        // Start the game
        int money = 3000;
        round1.start(money);
        //int goal;
        //boolean win = true;
    }

    public void start(int budget) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Junior Money Masters!");

        // Prompt the player for their name
        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine();

        // Display a personalized greeting
        System.out.println("Hey, " + playerName + "! Let's see if you can survive college by completing the financial literacy game!");
        // Create a Scanner object to read user input

        System.out.println("Your parents decide to give you $" + budget + " allowance for your entire college life. You can choose what you want to do with it.");
        System.out.println("type okay to continue");
        String okay = scanner.nextLine();
        while(!okay.equals("okay")){
            System.out.println("type okay to continue");
            okay = scanner.nextLine();
        }
        Player player = new Player(playerName, budget);
        System.out.println("The first day of school comes around and you have to buy the textbook which costs $350");
        player.setBudgetAmount(player.getBudgetAmount() - 350);
        System.out.println("You have $" + player.getBudgetAmount() + " left");

        Choice[] choices = {new Choice("only necessities", 60, 5, "misc"), new Choice("additional stationary", 90, 0, "misc")};
        Choice.compareChoices(player, choices);

        choices = new Choice[]{new Choice("buy a new laptop", 1000, 0, "misc"), new Choice("buy a used laptop", 500, 10, "misc")};
        Choice.compareChoices(player, choices);

        // Add additional options following this general format

        // Close the scanner


        scanner.close();
    }
}
