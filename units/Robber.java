package units;

import java.util.ArrayList;

// разбойник


public class Robber extends Character {

    private int level;
    
    public Robber(String name, Point2D pos) {
        super(name, 2, 1000, 70, 60, 10, 1, pos);
        level = 1;
    }

    @Override
    public String toString() {
        return String.format("[Разбойник] " + name + " " + position);
    }

    private boolean isMoved(Point2D pos, ArrayList<Character> character)
    {
        for (Character ch : character)
        {
            if (ch.getHeals() > 0 && ch.position.equal(pos))
                return false;
        }
        return true;
    }



    private void move(Character target, ArrayList<Character> friends)
    {
        int[] px = {1, 0, -1, 0};       // координаты возможных ходов (вправо, вниз, влево, вверх)
        int[] py = {0, 1, 0, -1};

        // ищем кратчайший возможный ход в сторону противника
        Point2D newPos = new Point2D(position.getX(),position.getY());
        int minIdx = -1;
        float minDist = Float.MAX_VALUE;
        for (int i = 0; i < 4; i++)
        {
            newPos.setXY(position.getX()+px[i], position.getY()+py[i]);
            if (isMoved(newPos, friends))
            {
                // сюда ходить можно, но нужно убедиться - кратчайший ли это путь?
                float dist = position.fastDistance(target.position, px[i], py[i]);
                if (dist < minDist)
                {
                    minIdx = i;
                    minDist = dist;                }
            }
        }
        if (minIdx == -1.0f)
            return;

        position.increment(px[minIdx], py[minIdx]);

        history = String.format(" пошёл на (%s)", position.toString());
    }


    private void attack(Character target, boolean isMoved)
    {
        int damage = getRound(power, 10) + (power / 10) * level;
        boolean critical = (this.agility/3) >= rnd.nextInt(100);
        if (critical)
        {
            damage *= 2.0f;
        }
        if (isMoved)
            damage /= 2;                        // удар с хода

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
        Character target = this.findNearestPerson(enemies);
        if (health <= 0 || target == null)
            return;

        if (position.distanceTo(target.position) < 1.5f)
        {
            // бьём
            attack(target, false);
        } else {
            move(target, friends);
            if (position.distanceTo(target.position) < 1.5f)
            {
                // бьём с ходу, с меньшей силой
                attack(target, true);
            }
        }

    }

}
