package units;

import java.util.ArrayList;

// крестьянин
public class Peasant extends Character {

    private int arrowsNum;
    boolean inGame = true;

    public Peasant(String name, Point2D pos) {
        super(name, 2, 44, 61, 50, 85, 31, pos);
    }

    public void giveArrows(int val) {
        this.arrowsNum -= val;
        if (!isInGame()) {
            inGame = false;
        }
    }

    public boolean isInGame() {
        return this.arrowsNum == 0 ? false : true;
    }

    @Override
    public String toString() {
        return String.format("[Крестьянин] " + name + " " + position);
    }

    @Override
    public void step(ArrayList<Character> enemies) {

    }


    


}
