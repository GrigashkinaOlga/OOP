package units;

public class Wizard extends Character {
    private int mana;
    private int healVal;
    private int healPrice;
    private int attackPrice;

    public Wizard(String name, int age) {
        super(name, age, 80, 40, "stick", 80, 60, 90);
        this.mana = 10;
        this.healPrice = 2;
        this.attackPrice = 1;

    }

    public void attack(Character character) {
        character.health -= this.power;
        this.mana -= price("attack");
    }

    public void heal(Character character) {
        character.health += this.healVal;
        this.mana -= price("heal");
    }

    public void heal() {
        super.health += this.healVal;
        this.mana -= price("heal");
    }

    private int price(String action) {
        if (action == "heal") return healPrice;
        else if (action == "attack") return attackPrice;
        return 0;
    }





}
