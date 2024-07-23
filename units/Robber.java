package units;

import java.util.ArrayList;

// разбойник


public class Robber extends Character {
    
    public Robber(String name, Point2D pos) {
        super(name, 2, 44, 61, 50, 85, 31, pos);

    }

    public void attack(Character character) {
        character.health -= this.power;

    }


    @Override
    public String toString() {
        return String.format("[Разбойник] " + name + " " + position);
    }

    @Override
    public void step(ArrayList<Character> enemies) {

    }



}
