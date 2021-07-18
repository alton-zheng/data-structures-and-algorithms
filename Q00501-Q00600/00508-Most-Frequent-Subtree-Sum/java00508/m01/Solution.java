package java00508.m01;

/**
 * @Author: alton
 * @Date: Created in 7/18/21 12:42 PM
 * @Description:
 * 508. Most Frequent Subtree Sum #220
 *
 * Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
 *
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,2,-3]
 * Output: [2,-3,4]
 * Example 2:
 *
 *
 * Input: root = [5,2,-5]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
 *
 * Time Complexity: O(N)
 * Space Complexity : O(N)
 */

import java00000.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<Integer,Integer> sumCount = new HashMap<>();
    int maxFrequent = 0;

    public int[] findFrequentTreeSum(TreeNode root) {

        postOrder(root);

        int max = 0;

        List<Integer> help = new ArrayList<>();
        for (Map.Entry<Integer, Integer> next : sumCount.entrySet()) {
            if (next.getValue() == maxFrequent) {
                help.add(next.getKey());
            }
        }

        int[] res = new int[help.size()];

        for (int i = 0; i < help.size(); i++) {
            res[i] = help.get(i);
        }

        return res;
    }

    public int postOrder(TreeNode node){

        if(node == null) {
            return 0;
        }

        int left = postOrder(node.left);
        int right = postOrder(node.right);
        int sum = left + right + node.val;

        int cnt = sumCount.getOrDefault(sum,0) + 1;
        sumCount.put(sum, cnt);
        maxFrequent = Math.max(maxFrequent, cnt);
        return sum;
    }
}
