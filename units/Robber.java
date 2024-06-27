package units;

// разбойник


public class Robber extends Character {
    
    public Robber(String name, int age) {
        super(name, age, 78, 61, "knife", 10, 56, 59);

    }

    public void attack(Character character) {
        character.health -= this.power;

    }

    public void stealGold(int val) {
        this.gold += val;

    }


}
