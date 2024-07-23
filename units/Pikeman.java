package units;

import java.util.ArrayList;

public class Pikeman extends Character {

    public Pikeman(String name, Point2D pos) {
        super(name, 2, 44, 61, 50, 85, 31, pos);
    }
    @Override
    public String toString() {
        return String.format("[Копейщик] " + name + " " + position);
    }

    @Override
    public void step(ArrayList<Character> enemies) {

    }
}
