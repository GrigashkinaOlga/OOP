package units;

public class Wizard extends Character {
    private int mana;
    private int healVal;
    private int healPrice;
    private int attackPrice;

    public Wizard(String name, int x, int y) {
        super(name, 2, 80, 40, "stick", 80, 60, 90, x, y);
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

    @Override
    public String toString() {
        return String.format("[Колдун] " + name + " " + position);
    }





}
