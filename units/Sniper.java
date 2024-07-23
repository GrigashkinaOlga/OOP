package units;

import java.util.ArrayList;

// лучник


public class Sniper extends Character {

    private int arrows; // боеприпасы
    private int maxArrows;
    private int level;
    private int effectivDistance;
    
    public Sniper(String name, Point2D pos) {
        super(name, 3, 800, 30, 30, 5, 16, pos);
        this.arrows = 12;
        this.maxArrows = arrows;
        this.effectivDistance = 4;
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

    public Character findNearestEnemy(ArrayList<Character> enemies) {
        Character target = null;
        float distance = Integer.MAX_VALUE;

        for (Character ch : enemies) 
        {
            float n = ch.distanceTo(this);
            if (n < distance) 
            {
                distance = n;
                target = ch;
            }
        }
        return target;
    }

    @Override
    public String toString() {
        return String.format("[Лучник] " + name + " " + position);
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
    public void step(ArrayList<Character> enemies) {

        if (health <=0 || arrows <=0)
            return;
        Character target = this.findNearestEnemy(enemies);
        if (target != null) {
            shot(target);
        }




    }


}