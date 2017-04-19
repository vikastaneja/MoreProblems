/**
 * Created by vikastaneja on 4/9/17.
 */
public class NumIslands {

    public static void main(String[]args) {
        int [][]a = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(numIslands(a));
    }

    public static int numIslands(int [][]a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return 0;
        }

        int rows = a.length;
        int cols = a[0].length;
        boolean[][]b = new boolean[rows][cols];
        int counter = 0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (a[i][j] == 1 && !b[i][j]) {
                    counter ++;
                    visitIsland(a, b, i, j);
                }

        return counter;
    }

    public static void visitIsland(int[][]a, boolean[][]b, int i, int j) {
        if (a == null || b == null
                || a.length == 0 || b.length == 0
                || a[0].length == 0 || b[0].length == 0
                || i < 0 || j < 0 || i == a.length || j == a[0].length)
            return;

        b[i][j] = true;

        if (i + 1 < a.length && a[i+1][j] == 1 && !b[i + 1][j])
            visitIsland(a, b, i + 1, j);

        if (j + 1 < a[0].length && a[i][j+1] == 1 && !b[i][j+1])
            visitIsland(a, b, i, j + 1);

        if (i - 1 >= 0 && a[i-1][j] == 1 && !b[i - 1][j])
            visitIsland(a, b, i - 1, j);

        if (j - 1 >= 0 && a[i][j-1] == 1 && !b[i][j-1])
            visitIsland(a, b, i, j-1);
    }
}
