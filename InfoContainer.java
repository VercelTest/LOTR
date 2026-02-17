public class InfoContainer {
    private int damage;
    private String message;

    public InfoContainer(int d, String m) {
        damage = d;
        message = m;
    }

    public String getMessage() {
        return message;
    }

    public int getDamage() {
        return damage;
    }
}
