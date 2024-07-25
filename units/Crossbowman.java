package units;

import java.util.ArrayList;

public class Crossbowman extends Character {

    protected int arrows; // стрелы
    protected int maxArrows;
    protected int level;
    protected int effectivDistance;
    
    public Crossbowman(String name, Point2D pos) {
        super(name, 3, 800, 35, 20, 5, 16, pos);
        this.arrows = 12;
        this.maxArrows = arrows;
        this.effectivDistance = 3;
        this.level = 1;
    }

    public int getArrows() {
        return arrows;
    }

    public int getMaxArrows() {
        return maxArrows;
    }

    protected void setArrows(int arrows)
    {
        this.arrows = Math.min(arrows, maxArrows);
    }


    @Override
    public String toString() {
        return String.format("[Арбалетчик] " + name + " " + position.toString());
    }

    protected void shot(Character target) {
        arrows--;
        float dist = position.distanceTo(target.position);
        int damage = getRound(power, 10) + (power / 10) * level;;
        if (dist > effectivDistance)
            damage *= 0.5;
        else if (dist < effectivDistance)
            damage *= 1.2;
        boolean critical = (this.agility/3) >= rnd.nextInt(100);
        if (critical) {
            damage *= 2.0f;
            }
        int res = target.getDamage(damage);
        history = String.format(" атаковал %s ", target);
        if (res == 0)
        {
            history += "но он увернулся!";
        } else {
            history += "и нанёс ";
            if (critical)
            {
                history += "критический ";
            }
            history += "урон в " + res;
        }

    }


    @Override
    public void step(ArrayList<Character> enemies, ArrayList<Character> friends) {
        history = "";

        if (health <=0 || arrows <=0)
            return;
        Character target = this.findNearestPerson(enemies);
            if (target != null) {
                shot(target);
            }
        else {
        history = String.format(" ждёт подвоза стрел.");
        }




    }
}
