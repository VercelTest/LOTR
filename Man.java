public class Man extends Player {

    private int blockProb = 1;

    public Man(String n) {
        super(n, 33, 6, 4);
    }

    public void takeDamage(int amount) {
        if (rollDie() < blockProb) {
            System.out.println(getName() + " has blocked the attack!");
        } else {
            changeHealth(-amount);
        }
    }
}