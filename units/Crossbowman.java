package units;

public class Crossbowman extends Character {

    public Crossbowman(String name, int x, int y) {
        super(name, 2, 44, 61, "stick", 85, 31, 29, x, y);
    }

    public void attack(Character character) {
        character.health -= this.power;
    }

    @Override
    public String toString() {
        return String.format("[Арбалетчик] " + name + " " + position);
    }
}
