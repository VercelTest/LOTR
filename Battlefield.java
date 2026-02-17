public class Battlefield {
    
    public static void main(String[] args) {
        Thing scaryLarry = new Thing("Scary Larry", 33);
        Player wolverine = new Player("Wolverine", 17, 5, 7);

        while (wolverine.getHealth() > 0 && scaryLarry.getHealth() > 0) {

            double attackRoll = Math.random();
            Player attacker;
            Player defender;

            if (attackRoll < 0.5) {
                attacker = scaryLarry;
                defender = wolverine;
            } else {
                attacker = wolverine;
                defender = scaryLarry;
            }

            InfoContainer result = attacker.attack(defender);

            System.out.println(result.getMessage());
            defender.takeDamage(result.getDamage());
    
            System.out.println(scaryLarry.getName() + "'s Health: " + scaryLarry.getHealth());
            System.out.println(wolverine.getName() + "'s Health: " + wolverine.getHealth());
        }
    }
}