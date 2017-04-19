/**
 * Created by vikastaneja on 4/2/17.
 */

import java.util.*;
public class Permutation {
    public static void main(String[] args) {
        Permutation s = new Permutation();
        List<String> list = s.permutation("abc");
        System.out.println(list);

    }

    /**
     * Function that returns a list of all permutations of a word<br/>
     * The logic is that:<br/>
     * First remove the first character.<br/>
     * Find the permuatations of remaining word.<br/>
     * For each of those words, put the the first character at every location<br/>
     * Return the final list
     * @param word
     * @return List
     */
    public List<String> permutation(String word) {
        if (word == null || word.length() == 0) {
            return new ArrayList<String>();
        }

        // If word is of single character, create a list and return
        if (word.length() == 1) {
            return Arrays.asList(word);
        }

        // Recurse until we get list of single character word list
        List<String> w = permutation(word.substring(1));

        // Fetch first character of original word
        Character ch = word.charAt(0);

        List<String> result = new ArrayList<String>();

        // Iterate over the list returned as part of recursion and append to each character of the words in the list.
        for(String s : w) {
            result.addAll(append(s, ch));
        }

        // Return the resultant string
        return result;
    }


    private List<String> append(String s, Character ch) {
        if (s == null) {
            return new ArrayList<String>();
        }

        if (ch == null) {
            return Arrays.asList(s);
        }

        // Iterate over the string and append character at each point in the string
        // Note that since we will have to append to the end, hence we will have to special case the last character too.
        List<String> result = new ArrayList<String>();
        for (int i = 0; i <= s.length(); i++) {
            String temp = s.substring(0,i) + String.valueOf(ch);
            if (i < s.length()) {
                temp += s.substring(i);
            }

            result.add(temp);
        }

        return result;
    }
}
