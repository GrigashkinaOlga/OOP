package units;

// крестьянин
public class Peasant extends Character {

    private int arrowsNum;
    boolean inGame = true;

    public Peasant(String name, int x, int y) {
        super(name, 1, 66, 30, "arrow", 10, 5, 32, x, y);
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


}
