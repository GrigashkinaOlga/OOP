package units;

import java.util.ArrayList;

// лучник


public class Sniper extends Character {
   
    private int arrowsNum;
    boolean inGame = true;
    
    public Sniper(String name, int x, int y) {
        super(name, 2, 60, 50, "gun", 30, 20, 60, x, y);

    }

    public void attack(Character character) {
        character.health -= this.power;
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

    public Character findNearestEnemy(ArrayList<Character> enemies) {
        Character target = null;
        double distance = Integer.MAX_VALUE;

        for (Character ch : enemies) 
        {
            double n = ch.distanceTo(this);
            if (n < distance) 
            {
                distance = n;
                target = ch;
            }
        }
        return target;
    }

    @Override
    public String toString() {
        return String.format("[Лучник] " + name + " " + position);
    }

}