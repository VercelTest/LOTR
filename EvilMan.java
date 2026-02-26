public class EvilMan extends Player {

    private int blockProb = 1;

    public EvilMan(String n) {
        super(n, 23, 6, 4);
    }

    public void takeDamage(int amount, Player attacker) {   
        if (rollDie() <= blockProb) {
            System.out.println(getName() + " has taken revenge on" + attacker.getName() + "!! (1/2) damage");
            attacker.takeDamage(amount / 2, this);
        } else {
            changeHealth(-amount);
        }
    }
}