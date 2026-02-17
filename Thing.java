public class Thing extends Player {

    private int evilProb = 1;

    public Thing(String n, int h) {
        super(n, 1000, 1, 1);
    }

    public InfoContainer attack(Player defender) {
        int outdamage = 0;
        String outmessage = "";

        if (rollDie() < getAttackProb()) {
            outmessage = getName() + " is viewing this match";
            outdamage = getAttackPower();
        } else {
            outmessage = getName();
        }

        return new InfoContainer(outdamage, outmessage);
    }


    public void takeDamage(int amount) {
        if (rollDie() < evilProb) {
            System.out.println(getName() + " has been angered. " + getName() + " has decided your fate. Thank you for playing.");
            ByeCommand.ok();
        } else {
            System.out.println(getName() + " is not affected by mortals");
        }
    }
}