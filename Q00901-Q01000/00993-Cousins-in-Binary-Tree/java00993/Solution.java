package java00993;

/**
 * @Author: alton
 * @Date: Created in 5/17/21 9:02 AM
 * @Description: 993. Cousins in Binary Tree
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(depth)
 */
// 深度优先
class Solution {

    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {

        this.x = x;
        this.y = y;

        if (root.val == x || root.val == y) {
            return false;
        }

        depthFirstTraversal(root, root.left, root.right, 0);

        return xDepth == yDepth && xParent != yParent;
    }

    private void depthFirstTraversal(TreeNode node, TreeNode left, TreeNode right, int depth) {

        if (node == null) {
            return;
        }

        if (left != null) {

            updateInfo(left, node, depth + 1);
            depthFirstTraversal(left, left.left, left.right, depth + 1);

        }

        if (right != null) {

            updateInfo(right, node, depth + 1);
            depthFirstTraversal(right, right.left, right.right, depth + 1);

        }

    }

    private void updateInfo(TreeNode node, TreeNode parent, int depth) {

        if (node.val == x) {
            xParent = parent;
            xFound = true;
            xDepth = depth;
        }

        if (node.val == y) {
            yParent = parent;
            yFound = true;
            yDepth = depth;
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3)
        );

        System.out.println(new Solution().isCousins(root, 5, 4));
    }
}
