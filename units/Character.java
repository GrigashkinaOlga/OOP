package units;

import java.util.Random;

public class Character {

    protected static Random rnd;
    static {
        rnd = new Random();
    }
    
    protected String name;   // protected чтоб было видно только в пакете и наследниках, а в main нет
    protected int age;
    protected int priority;  //приоритет хода
    protected int health;  // здоровье
    protected int maxHealth;
    protected int endurance; // выносливость
    protected String weapon; // оружие
    protected int power; // сила
    protected int gold;
    protected int armor;  // броня

    protected Point2D position;

    public Character(String name, int age, int health, int endurance, String weapon, int power, int gold, int armor, int x, int y) { 
        this.name = name;
        this.health = health;
        this.age = age;
        this.endurance = endurance;
        this.weapon = weapon;
        this.power = power;
        this.gold = gold;
        this.armor = armor;
        position = new Point2D(x,y);

    }

// задает местоположение персонажа
    public void setPosition(int x, int y) {
        position.setX(x);
        position.setX(y);

    }

// опредление расстояния до другого персонажа
    public int distanceTo(Character target) {
        double x = position.getX() - target.position.getX();
        double y = position.getY() - target.position.getX();
        return (int) Math.sqrt(x*x + y*y);
    }




}
