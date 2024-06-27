package units;

public class Crossbowman extends Character {

    public Crossbowman(String name, int age) {
        super(name, age, 44, 61, "stick", 85, 31, 29);
    }

    public void attack(Character character) {
        character.health -= this.power;
    }
    
}
