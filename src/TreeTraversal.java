import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vikastaneja on 4/18/17.
 */

public class TreeTraversal {


    public static void printBFS(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.remove();
            if (t.left != null)
                queue.add(t.left);

            if (t.right != null)
                queue.add(t.right);
            System.out.println(t.value);
        }
    }

    public static void printDFS(TreeNode root) {
        if(root == null)
            return;

        System.out.print(root.value);
        printDFS(root.left);
        printDFS(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = getNewNode("A");
        root.left = getNewNode("B");
        root.right = getNewNode("C");
        root.left.left = getNewNode("D");
        root.left.right = getNewNode("E");
        root.right.left = getNewNode("F");
        root.right.right = getNewNode("G");

        printBFS(root);
        printDFS(root);
    }

    public static TreeNode getNewNode(String val) {
        TreeNode treeNode = new TreeNode();
        treeNode.value = val;

        return treeNode;
    }
}
