package units;

import java.util.ArrayList;

// крестьянин
public class Peasant extends Character {

    private static final int FULL_BAG = 240;

    private int bag;  // сколько стрел имеем с собой

    public Peasant(String name, Point2D pos) {
        super(name, 0, 500, 30, 30, 0, 1, pos);
        bag = FULL_BAG;
    }


    @Override
    public void step(ArrayList<Character> enemies, ArrayList<Character> friends)
    {
        history = "";

        if (health <= 0 || bag <= 0)
            return;
        Sniper s = (Sniper) getShooter(friends);
        if (s != null)
        {
            if (s.getArrows() < s.getMaxArrows())
            {
                s.setArrows(s.getArrows()+1);
                bag--;
                history = String.format(" дал стрелу %s", s);
            }
        }
    }

// Ищет подходящего стрелка, с наименьшим запасом стрел

    private Character getShooter(ArrayList<Character> friends)
    {
        Character ch = null;
        int min = Integer.MAX_VALUE;

        for (Character friend : friends)
        {
            if (friend.getHeals() > 0 && friend instanceof Sniper)
            {
                if (min > ((Sniper) friend).getArrows())
                {
                    min = ((Sniper) friend).getArrows();
                    ch = friend;
                }
            }
        }
        return ch;
    }

    @Override
    public String toString() {
        return String.format("[Крестьянин] " + name + " " + position);
    }



    


}
