/**
 * Created by vikastaneja on 4/18/17.
 */
public class BinarySearch {

    private static boolean isElementPresent(int []a, int e) {
        if (a == null || a.length == 0) {
            return false;
        }

        int l = 0, h = a.length - 1;

        while (l <= h) {
            int mid = (h + l) / 2;
            if (a[mid] == e) return true;
            if (a[mid] > e) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(isElementPresent(a, 3));
        System.out.println(isElementPresent(a, 7));
        System.out.println(isElementPresent(a, 5));
        System.out.println(isElementPresent(a, 10));
        System.out.println(isElementPresent(a, 1));
        System.out.println(isElementPresent(a, 0));
        System.out.println(isElementPresent(a, 11));
    }
}
