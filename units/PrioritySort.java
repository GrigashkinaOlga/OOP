package units;

import java.util.Comparator;

    public class PrioritySort  implements Comparator<Character> {

    @Override
    public int compare(Character o1, Character o2) {
        return Integer.compare(o2.priority, o1.priority);
    }
}
