package units;

public class Pikeman extends Character {

    public Pikeman(String name, int x, int y) {
        super(name, 5, 56, 56, "stick", 70, 45, 63, x, y);
    }
    @Override
    public String toString() {
        return String.format("[Копейщик] " + name + " " + position);
    }
}
