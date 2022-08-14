public class Players {
    private int id;
    private String name;
    private int strength;

    public Players(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }

}