/**
 * Created by vikastaneja on 4/16/17.
 */
public class LongestSubsequence {
    public static void fillTMatrix(int[][]T, char[]a1, char[]a2) {
        if(T == null || a1 == null || a2 == null)
            return;

        if(T.length != a2.length+1 || T[0].length != a1.length+1) return;

        for (int i = 1; i < a2.length+1; i++)
            for (int j = 1; j < a1.length+1; j++)
                if (a1[j-1] == a2[i-1])
                    T[i][j] = T[i-1][j-1] + 1;
                else
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);


        return;
    }

    public static void printLargestSubsequence(int[][]T, char[]a1, char[]a2) {
        String o = "";
        for(int i = a2.length, j = a1.length; i > 0 && j > 0;) {
            if (a2[i-1] == a1[j-1] && T[i-1][j-1] + 1 == T[i][j]) {
                o = String.valueOf(a2[i-1]) + o;
                i--;
                j--;
            } else {
                if (T[i][j] == T[i-1][j])
                        i--;
                else j--;
            }
        }

        System.out.println(o);
    }

    public static int findLongestSubseqLength(char[] a1, char[]a2) {
        if (a1 == null || a2 == null)
            return -1;

        if ( a1.length == 0 || a2.length == 0)
            return 0;

        int [][]T = new int[a2.length + 1][a1.length + 1];

        fillTMatrix(T, a1, a2);
        printLargestSubsequence(T, a1, a2);
        return T[a2.length][a1.length];
    }

    public static void main(String[] args) {
        String a1 = "abccdabac";
        String a2 = "acmcbx";

        System.out.println(findLongestSubseqLength(a1.toCharArray(), a2.toCharArray()));

    }
}
