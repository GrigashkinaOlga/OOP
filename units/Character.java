package units;


import java.util.Random;

public abstract class Character implements ActionInterface {

    protected static Random rnd;
    static {
        rnd = new Random();
    }
    
    protected String name;   // protected чтоб было видно только в пакете и наследниках, а в main нет
    protected int priority;
    protected int health;  //приоритет хода
    protected final int maxHealth;  // здоровье
    protected final int power;
    protected final int agility; // ловкость
    protected final int defence; // защита
    protected int distance; // дистанция взаимодействия


    protected Point2D position;

    protected String history;

    public Character(String name, int priority, int health, int power, int agility, int defence, int distance, Point2D pos) { 
        this.name = name;
        this.priority = priority;
        this.health = getRound(health, 10);
        this.maxHealth = this.health;
        this.power = getRound(power, 10);
        this.agility = getRound(agility, 10);
        this.defence = defence;
        this.distance = distance;
        this.history = "";
        this.position = pos;

    }

    public int getHeals() {
        return health;
    }

    public int getMaxHeals() {
        return maxHealth;
    }

    public int getPriority() {
        return priority;
    }

// Возвращает значение со случайной погрешностью в +-percent%

    protected int getRound(int origin, int percent)
    {
        if (percent > origin)
            return origin;
        int n = (origin * percent) / 100;
        return origin + (rnd.nextInt(0, n * 2+1)- n);
    }

// задает местоположение персонажа
    public void setPosition(int x, int y) {
        position.setXY(x, y);

    }

// Возвращает текущее местоположение персонажа
    public Point2D getPosition()
    {
        return position;
    }   

// Лечение персонажа
    public void healed(int health)
    {
        this.health = Math.min(this.health +health, this.maxHealth);
    }

//Персонаж принимает урон
    public int getDamage(int damage)
    {
        boolean probability = (this.agility/2) >= rnd.nextInt(100);
        if (probability)
        {
//            System.out.print(" но " + name + " увернулся!");
            return 0;           // увернулись
        }

        int loss = damage - (this.defence * damage) / 100;
        loss = Math.min(loss, this.health);
        this.health -= loss;
//        if (this.health <= 0)
//        {
//            System.out.println(name + ": вышел из чата!");
//        }
        return loss;
    }



// опредление расстояния до другого персонажа
    public float distanceTo(Character target) {
        float x = position.getX() - target.position.getX();
        float y = position.getY() - target.position.getY();
        return (float) Math.sqrt(x*x + y*y);
    }




}
