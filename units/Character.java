package units;

public class Character {
    protected String name;   // protected чтоб было видно только в пакете и наследниках, а в main нет
    protected int age;
    protected int health;  // здоровье
    protected int endurance; // выносливость
    protected String weapon; // оружие
    protected int power; // сила
    protected int gold;
    protected int armor;  // броня

    public Character(String name, int age, int health, int endurance, String weapon, int power, int gold, int armor) { 
        this.name = name;
        this.health = health;
        this.age = age;
        this.endurance = endurance;
        this.weapon = weapon;
        this.power = power;
        this.gold = gold;
        this.armor = armor;
    }

    @Override
    public String toString() {
        return name;
    }

}
