public class EvilMan extends Player {

    private int blockProb = 1;

    public EvilMan(String n) {
        super(n, 23, 6, 4);
    }

    public void takeDamage(int amount, Player defender) {   
        if (rollDie() < blockProb) {
            System.out.println(getName() + " has taken revenge on" + defender.getName() + "!! (1/2) damage");
            defender.takeDamage(amount / 2, this);
        } else {
            changeHealth(-amount);
        }
    }
}