public class Thing extends Player {

    private int evilProb = 1;

    public Thing(String n) {
        super(n, 1000, 1, 1);
    }

    public InfoContainer attack(Player defender) {
        int outdamage = 0;
        String outmessage = "";

        if (rollDie() <= getAttackProb()) {
            outmessage = ColorText.ANSI_BG_BRIGHT_BLACK + getName() + " has removed a piece of " + defender.getName() + ColorText.ANSI_RESET;
            outdamage = getAttackPower();
        } else {
            outmessage = getName() + " has instead, chosen peace";
        }

        return new InfoContainer(outdamage, outmessage);
    }


    public void takeDamage(int amount, Player attacker) {
        if (rollDie() < evilProb) {
            System.out.println(getName() + " has been angered. " + getName() + " has decided your fate. Thank you for playing.");
            ByeCommand.ok();
        } else {
            changeHealth(-(amount / 2));
            System.out.println(getName() + " is slightly affected by mortals.");
        }
    }
}