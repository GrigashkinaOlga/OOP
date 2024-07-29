package Controller;
import units.*;
import units.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import View.View;


public class main {
    
    public static ArrayList<Character> red = new ArrayList<>();
    public static ArrayList<Character> blue = new ArrayList<>();
    public static ArrayList<Character> all = new ArrayList<>();
    
    public static void main(String[] args) {
        
        createTeam(red, 10, 0);
        createTeam(blue, 10, 3);
        all.addAll(red);
        all.addAll(blue);

        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));


        Scanner in = new Scanner(System.in);
            while (true)
            {
                View.view();

                for (Character ch : all) {
                    if (red.contains(ch)) {
                        ch.step(blue, red);
                    }
                    else {
                        ch.step(red, blue);
                    }
                    System.out.println(ch.getInfo());
                }
                in.nextLine();
                if (!isLiving(red))
                {
                    System.out.println("Blue team wins!");
                    break;
                }
                if (!isLiving(blue))
                {
                    System.out.println("Red wins!");
                    break;
                }

            }
        }

    private static boolean isLiving(ArrayList<Character> team)
    {
        for (Character ch : team) {
            if (ch.getHeals() > 0)
                return true;
        }
        return false;
    }

    public static void setDied(ArrayList<Character> team, int num)
    {
        for (Character p : team) {
            if (p instanceof Wizard || p instanceof Monk)
                continue;
            p.healed(-p.getHeals());
            num--;
            if (num <= 0)
                break;
        }
    }

    public static void setManas(ArrayList<Character> team, int mana)
    {
        for (Character p : team) {
            if (p instanceof Wizard || p instanceof Monk)
            {
                ((Monk) p).setMana(mana);
            }
        }
    }


    public static void createTeam(ArrayList<Character> team, int num, int start) {
        Random rnd = new Random();
        int cy = 1;
        while (num-- > 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Pikeman(names.getRandomName(), new Point2D(9, cy)));
                    break;
                case 1:
                    team.add(new Crossbowman(names.getRandomName(), new Point2D(9, cy)));
                    break;
                case 2:
                    team.add(new Wizard(names.getRandomName(), new Point2D(9, cy)));
                    break;
                case 3:
                    team.add(new Peasant(names.getRandomName(), new Point2D((3-start)*3, cy)));
                    break;
                case 4:
                    team.add(new Monk(names.getRandomName(), new Point2D(0, cy)));
                    break;
                case 5:
                    team.add(new Sniper(names.getRandomName(), new Point2D(0, cy)));
                    break;
                case 6:
                    team.add(new Robber(names.getRandomName(), new Point2D(0, cy)));
                    break;

            }
            cy++;
        }
    }


}
