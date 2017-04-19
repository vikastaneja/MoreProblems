import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by vikastaneja on 4/17/17.
 */
public class MergeSortedPairs {

    private static List<Pair<Integer, Integer>> merge(List<Pair<Integer, Integer>>list) {
        if (list == null) {
            return new ArrayList<Pair<Integer, Integer>>();
        }

        if (list.size() <= 1) {
            return list;
        }

        Stack<Pair<Integer, Integer>> s = new Stack<Pair<Integer, Integer>>();
        s.push(list.remove(0));
        for (Pair<Integer, Integer>p : list) {
            Pair<Integer, Integer> t = s.pop();
            if (t.getValue() < p.getKey()) {
                s.push(t);
                s.push(p);
            } else {
                int l = Math.min(t.getKey(), p.getKey());
                int r = Math.max(t.getValue(), p.getValue());
                Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(l, r);
                s.push(p1);
            }
        }

        list.clear();
        while(!s.isEmpty()) {
            list.add(0, s.pop());
        }

        return list;
    }

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>() {
            {
                add(new Pair<Integer, Integer>(1,5));
                add(new Pair<Integer, Integer>(2,6));
                add(new Pair<Integer, Integer>(2,8));
                add(new Pair<Integer, Integer>(9,15));
            }
        };

        List<Pair<Integer, Integer>> list1 = merge(list);
        for (Pair<Integer, Integer> p : list1) {
            System.out.println(p.getKey() + "," + p.getValue());
        }
    }
}
