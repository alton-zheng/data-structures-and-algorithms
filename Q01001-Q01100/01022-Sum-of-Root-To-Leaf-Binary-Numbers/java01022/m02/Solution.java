package java01022.m02;

import java00000.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: alton
 * @Date: Created in 2021/7/27 10:30 上午
 * @Description:
 * 1022. Sum of Root To Leaf Binary Numbers #245
 *
 * You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0.1.1.0.1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Example 2:
 *
 * Input: root = [0]
 * Output: 0
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Example 4:
 *
 * Input: root = [1,1]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val is 0 or 1.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Runtime: 1 ms, faster than 46.04% of Java online submissions for Sum of Root To Leaf Binary Numbers.
 * Memory Usage: 38.5 MB, less than 59.34% of Java online submissions for Sum of Root To Leaf Binary Numbers.
 */
class Solution {

    public int sumRootToLeaf(TreeNode root) {

        // 迭代解法，利用 stk
        Deque<TreeNode> stk = new LinkedList<>();

        // 首先将 root push 进 stk
        stk.push(root);

        // 初始化结果值
        int res = 0;

        // stk 不为空进入迭代
        while(!stk.isEmpty()){

            // 取出节点并删除
            TreeNode cur = stk.pop();
            // 当前节点值
            int num = cur.val;

            // 当 left, right 为空
            if(cur.left == null && cur.right == null){

                // 将 leaf 节点值加到 res 结果中
                // 可能有朋友会认为这里的值少了，其实不然， leaf 值已经在下列逻辑中更新为所有二进制和了。
                res += cur.val;

                // 下列步骤，需要 left 或 right 不为空，没必要进行判断，进入下一迭代即可
                continue;
            }

            // left 不为空时, 说明 leaf 还未找到，继续
            if(cur.left != null){
                // 将 left 节点值更新为二进制和 （与递归中 parSum 用法一致）
                cur.left.val = (num << 1) | (cur.left.val);

                // 更新 left.val 后将 left 压栈
                stk.push(cur.left);
            }

            // right 不为空时，说明还未到 leaf
            if(cur.right != null){
                // 将 left.val 更新为二进制和 （与递归中 parSum 含义一致）
                cur.right.val = (num <<1) | (cur.right.val);

                // 更新 right.val 后, 将 right 压栈
                stk.push(cur.right);
            }

        }
        // 返回 res
        return res;
    }
}
