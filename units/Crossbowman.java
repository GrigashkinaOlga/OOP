package units;

import java.util.ArrayList;

public class Crossbowman extends Character {

    public Crossbowman(String name, Point2D pos) {
        super(name, 2, 44, 61, 50, 85, 31, pos);
    }

    public void attack(Character character) {
        character.health -= this.power;
    }

    @Override
    public String toString() {
        return String.format("[Арбалетчик] " + name + " " + position);
    }


    @Override
    public void step(ArrayList<Character> enemies) {

    }
}
