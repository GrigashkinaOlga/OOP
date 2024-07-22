package units;

// разбойник


public class Robber extends Character {
    
    public Robber(String name, int x, int y) {
        super(name, 5, 78, 61, "knife", 10, 56, 59, x, y);

    }

    public void attack(Character character) {
        character.health -= this.power;

    }

    public void stealGold(int val) {
        this.gold += val;

    }

    @Override
    public String toString() {
        return String.format("[Разбойник] " + name + " " + position);
    }


}
