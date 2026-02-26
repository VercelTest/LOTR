import java.util.ArrayList;
import java.util.Arrays;

public class Battlefield {
    
    public static void main(String[] args) {
        ArrayList<Player> PlayerList = new ArrayList<>(Arrays.asList(
            new Man("Scary Larry"), 
            new Player("Wolverine", 170, 5, 7),
            new Thing("Daisy"),
            new EvilMan("Duck")
        )
        );

        while (PlayerList.size() > 1) {

            int attackRoll = (int) (Math.random() * PlayerList.size());
            int defendRoll = (int) (Math.random() * PlayerList.size());

            // prevent self attack
            while (defendRoll == attackRoll) {
                defendRoll = (int) (Math.random() * PlayerList.size());
            }

            Player attacker;
            Player defender;

            attacker = PlayerList.get(attackRoll);
            defender = PlayerList.get(defendRoll);

            InfoContainer result = attacker.attack(defender);

            System.out.println(result.getMessage());
            defender.takeDamage(result.getDamage(), attacker);
            
            // after stats / death
            if (defender.getHealth() < 0) {
               System.out.println(defender.getName() + " has fallen to " + attacker.getName() + "! Bye!");
                PlayerList.remove(defender);
            } else {
               System.out.println(defender.getName() + "'s Health: " + defender.getHealth());
            }
        }

        System.out.println(PlayerList.get(0).getName() + " has won! Congratulations!");
    }


}