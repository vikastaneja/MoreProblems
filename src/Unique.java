/**
 * Created by vikastaneja on 4/2/17.
 */
public class Unique {
    /**
     * Finds unique value from a sorted array that has duplicates such as [1,1,2,2,3,3]<br/>
     * The approach is to have a O(log n) algorithm - perform operation as a binary search
     * @param a
     * @return
     */
    public static int findUnique(int []a) {
        if (a == null || a.length == 0) {
            throw new RuntimeException("Invalid parameter");
        }

        int length = a.length;
        if (length %2 == 0) return Integer.MIN_VALUE;

        // If only single element array, return the element
        if (length == 1) return a[0];

        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) /2;
            if (a[mid] == a[mid ^ 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return a[lo];
    }

    public static void main(String[] s) {
        System.out.println(findUnique(new int[]{1,1,2,2,3,4,4}));
        System.out.println(findUnique(new int[]{1,1,2,3,3,4,4}));
        System.out.println(findUnique(new int[]{1,2,2,3,3,4,4}));
//        System.out.println(findUnique(new int[]{1,1,2,2,3,3,4,4}));
        System.out.println(findUnique(new int[]{1,1,2,3,3,4,4,8,8}));

    }
}
