/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 * Input: root1 = [1], root2 = [1]
 * Output: true
 * Example 3:
 *
 * Input: root1 = [1], root2 = [2]
 * Output: false
 * Example 4:
 *
 * Input: root1 = [1,2], root2 = [2,2]
 * Output: true
 * Example 5:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 *
 * Time Complexity: O(root1.size() + root2.size())
 * Space Complexity: O(root1.size() + root2.size())
 *
 */


class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> seq1 = new ArrayList<>();

        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<>();

        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);

    }

    /**
     * 递归从左往右取叶子节点值
     * @param node
     * @param seq
     */
    public void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs (node.right, seq);
            }
        }
    }
}


