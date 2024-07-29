package units;

import java.util.ArrayList;

public interface ActionInterface {

    void step(ArrayList<Character> enemies, ArrayList<Character> friends);

    String getInfo();

}


