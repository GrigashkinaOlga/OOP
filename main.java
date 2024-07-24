import units.*;
import units.Character;

import java.util.ArrayList;
import java.util.Random;


public class main {
    
    public static ArrayList<Character> red = new ArrayList<>();
    public static ArrayList<Character> blue = new ArrayList<>();
    public static ArrayList<Character> all = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
        createTeam(red, 10, 0);
        createTeam(blue, 10, 3);
        all.addAll(blue);
        all.addAll(red);

        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));

        for (int i = 0; i <= 10; i++) {


            for (Character ch : all) {
                if (red.contains(ch)) {
                    ch.step(blue, red);
                }

                else {
                    ch.step(red, blue);
                }
                System.out.println();
            }
        }
    }

    public static void createTeam(ArrayList<Character> team, int num, int start) {
        Random rnd = new Random();
        while (-- num >= 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Pikeman(getName(), new Point2D(0, num)));
                    break;
                case 1:
                    team.add(new Crossbowman(getName(), new Point2D(0, num)));
                    break;
                case 2:
                    team.add(new Wizard(getName(), new Point2D(0, num)));
                    break;
                case 3:
                    team.add(new Peasant(getName(), new Point2D(start*3, num)));
                    break;
                case 4:
                    team.add(new Monk(getName(), new Point2D(9, num)));
                    break;
                case 5:
                    team.add(new Sniper(getName(), new Point2D(9, num)));
                    break;
                case 6:
                    team.add(new Robber(getName(), new Point2D(9, num)));
                    break;

            }
        }
    }
       
    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }
       

    
}
