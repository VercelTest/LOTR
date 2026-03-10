import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Battlefield {
    public static void main(String[] args) {
        boolean skip = false;
        ArrayList<Player> PlayerList = new ArrayList<>(Arrays.asList(
            new Man("Scary Larry"), 
            new Player("Wolverine", 17, 5, 7),
            new Thing("chimken"),
            new EvilMan("Duck")
        )
        );

        int attackMult = 1;
        // 0 = not chosen, 1 = double attack, 2 = swap health
        int specialRoundType = 0;
        Scanner scanner = new Scanner(System.in);
        while (PlayerList.size() > 1) {
            // round randomizer
            int attackRoll = (int) (Math.random() * PlayerList.size());
            int defendRoll = (int) (Math.random() * PlayerList.size());

            // prevent self attack
            while (defendRoll == attackRoll) {
                defendRoll = (int) (Math.random() * PlayerList.size());
            }

            int specialRoundRoll = (int) (Math.random() * 20);
            if (specialRoundRoll == 0) {
                System.out.println(ColorText.ANSI_BOLD_CYAN + "SPECIAL ROUND: DOUBLE ATTACK POINTS" + ColorText.ANSI_RESET);
                attackMult = 2;
                specialRoundType = 1;
            } else if (specialRoundRoll == 1) {
                specialRoundType = 2;
                System.out.println(ColorText.ANSI_BOLD_CYAN + "SPECIAL ROUND: SWAP HEALTH" + ColorText.ANSI_RESET);
            } 

            Player attacker;
            Player defender;

            attacker = PlayerList.get(attackRoll);
            defender = PlayerList.get(defendRoll);


            // attacking
            System.out.println(ColorText.ANSI_YELLOW + attacker.getName() + " is attempting to attack " + defender.getName() + "..." + ColorText.ANSI_RESET);
            if (!skip) {skip = promptNextKey(scanner);}

            InfoContainer result = attacker.attack(defender);
            
            // results + damage & resetting round
            System.out.println(result.getMessage());
            if (!skip) {skip = promptNextKey(scanner);}

            if (specialRoundType == 2 && result.getDamage() > 0) {
                int temphealth = defender.getHealth();
                defender.setHealth(attacker.getHealth());
                attacker.setHealth(temphealth);

                System.out.println(attacker.getName() + "'s Health: " + attacker.getHealth());
            } else {
                defender.takeDamage(result.getDamage() * attackMult, attacker);
            }

            attackMult = 1;
            specialRoundType = 0;
            
            // after stats / death
            if (defender.getHealth() <= 0) {
               System.out.println(defender.getName() + " has " + ColorText.ANSI_RED + "fallen" + ColorText.ANSI_RESET +" to " + attacker.getName() + "! Bye!");
                PlayerList.remove(defender);
            } else {
               System.out.println(defender.getName() + "'s Health: " + defender.getHealth());
            }
        }

        scanner.close();
        System.out.println(ColorText.ANSI_GREEN + PlayerList.get(0).getName() + " has won! Congratulations!" + ColorText.ANSI_RESET);
    }

    public static boolean promptNextKey(Scanner scanner) {
        System.out.println("Press \"ENTER\" to continue or press \"E + ENTER\" to skip to the end...");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("e")) {
            return true;
        }
        return false;
    }


}