package test;

public class MyTest {


    public static void main(String[] args) {


    }

    public class Node {
        Node left;
        Node right;
        int val;
    }

    //求二叉树的最大值路径
    public int getMaxPathSum(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = getPathValue(root.left);
        int right = getPathValue(root.right);
        return Math.max(Math.max(left + right + root.val, left + root.val), right + root.val);
    }

    /**
     *
     * @param root
     * @return
     */
    public int getPathValue(Node root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = getPathValue(root.left);
        int right = getPathValue(root.right);

        int max = left > right ? left : right;
        return Math.max(max,max + root.val);
    }


}
