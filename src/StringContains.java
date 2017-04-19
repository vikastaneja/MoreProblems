/**
 * Created by vikastaneja on 4/17/17.
 */
public class StringContains {

    private static void createTempArray(char[]c, int[]a) {
        int i = 1, j = 0;
        while (i < a.length) {
            if (c[i] == c[j]) {
                a[i] = j + 1;
                i++;
                j++;
                continue;
            }

            if (j == 0) {
                a[i] = 0;
                i++;
                continue;
            }

            j = a[j - 1];
            if (c[i] == c[j]) {
                a[i] = j + 1;
            } else {
                a[i] = a[j];
            }

            i++;
        }
    }

    public static boolean match(char[]a, char[]b) {
        if (a == null || b == null || a.length > b.length) {
            return false;
        }

        int[] t = new int[a.length];

        createTempArray(a, t);
        for (int ia = 0, ib = 0; ib < b.length && ia < a.length;) {
            while (ia < a.length && ib < b.length && a[ia] == b[ib]){
                ia++;
                ib++;
            }

            if (ia == a.length) return true;
            ia = ia > 0 ? t[ia - 1] : 0;
            while (ia < a.length && ib < b.length && a[ia] != b[ib]) {
                ib++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String a = "abcmabcx";
        String b = "aabxdefmabcmmabcmabcxyz";
        System.out.println(match(a.toCharArray(), b.toCharArray()));
    }
}
