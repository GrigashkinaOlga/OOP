package units;

// лучник


public class Sniper extends Character {
   
    private int arrowsNum;
    boolean inGame = true;
    
    public Sniper(String name, int age) {
        super(name, age, 60, 50, "gun", 30, 20, 60);

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

}