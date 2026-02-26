public class Player {
    private int health;
    private String name;
    private int attackPower;
    private int attackProb;  

    public Player(String n, int h, int aPow, int aProb) {
        health = h;
        name = n;
        attackPower = aPow;
        attackProb = aProb;
    }

    public void changeHealth(int amount) {
        health += amount;
    }
    
    public void takeDamage(int amount, Player attacker) {
        changeHealth(-amount);
    }

    public InfoContainer attack(Player defender) {
        int outdamage = 0;
        String outmessage = "";

        if (rollDie() <= attackProb) {
            outmessage = name + " successfully attacked " + defender.getName();
            outdamage = attackPower;
        } else {
            outmessage = name + " failed to attack " + defender.getName();
        }

        return new InfoContainer(outdamage, outmessage);
    }

    public String getName() {
        return name;
    }

    public int getAttackProb() {
        return attackProb;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int rollDie() {
        return (int) (Math.random() * 10) + 1;
    }

    public int getHealth() {
        return health;
    }
}
