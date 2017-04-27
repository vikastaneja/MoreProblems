import java.util.*;

/**
 * Created by vtaneja on 4/26/17.
 */
public class AllSubsets {

    // Alternative approach is to pass the set as a param. In that case, we will know what is added and hence we can decide what when to return immediately
    private static Set<List<Character>> getSubsets(List<Character> s) {
        if (s == null) return null;
        Set<List<Character>> set = new HashSet<List<Character>>();

        set.add(new ArrayList<Character>(s)); // If the element exists in the set, return from here. This is because the path forward is already traced.
        if (s.size() == 1) return set;

        for (int i = 0; i < s.size(); i++) {
            char ch = s.remove(i); // Alternatively, we can create a list without the indexed element. Then we don't have to add the element back in the following lines
            set.addAll(getSubsets(s)); // Here we can write down as if the set contains any of the returned elements, then don't add.
            s.add(i, ch);
        }

        return set;
    }

    private static void getSubsets(List<Character> s, Set<List<Character>> set) {
        if (s == null) return;
        if (set == null) return;

        // If the element exists in the set, return from here. This is because the path forward is already traced.
        if (set.contains(s)) return;
        else set.add(new ArrayList<Character>(s));
        if (s.size() == 1) return;

        for (int i = 0; i < s.size(); i++) {
            char ch = s.remove(i); // Alternatively, we can create a list without the indexed element. Then we don't have to add the element back in the following lines
            getSubsets(s, set); // Here we can write down as if the set contains any of the returned elements, then don't add.
            s.add(i, ch);
        }

    }
    public static void main(String[] args) {
        List<Character> ch = new ArrayList<Character>(){{
            add('a');
            add('b');
            add('c');
            add('d');
        }};

        Set<List<Character>> sub = getSubsets(ch);;
        for(List<Character> c : sub) {
            System.out.print(Arrays.toString(c.toArray()) + ":");
        }

        System.out.println();
        sub = new HashSet<List<Character>>();
        getSubsets(ch, sub);
        for(List<Character> c : sub) {
            System.out.print(Arrays.toString(c.toArray()) + ":");
        }
    }
}
