import units.*;
import units.Character;

import java.util.ArrayList;
import java.util.Random;

public class main {
    
    static ArrayList<Character> red = new ArrayList<>();
    static ArrayList<Character> blue = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
        createTeam(red, 10, 0);
        createTeam(blue, 10, 3);
        System.out.println();
        System.out.println(red + "\n");
        System.out.println(blue);

        Sniper sniper = new Sniper("Arny", 7, 4);
        Character target = sniper.findNearestEnemy(blue);
        System.out.println("Nearnest blue target at  " + target);
        target = sniper.findNearestEnemy(red);
        System.out.println("Nearnest red target at  " + target);
    

    }

    public static void createTeam(ArrayList<Character> team, int num, int start) {
        Random rnd = new Random();
        while (-- num >= 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Pikeman(getName(), 0, num));
                    break;
                case 1:
                    team.add(new Crossbowman(getName(), 0, num));
                    break;
                case 2:
                    team.add(new Wizard(getName(), 0, num));
                    break;
                case 3:
                    team.add(new Peasant(getName(), start*3, num));
                    break;
                case 4:
                    team.add(new Monk(getName(), 9, num));
                    break;
                case 5:
                    team.add(new Sniper(getName(), 9, num));
                    break;
                case 6:
                    team.add(new Robber(getName(), 9, num));
                    break;

            }
        }
    }
       
    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    
}
