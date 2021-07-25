package java0094.m03;

import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 37.3 MB, less than 62.44% of Java online submissions for Binary Tree Inorder Traversal.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {

		// 定义结果集 res
		List<Integer> res = new ArrayList<>();


		// 当然这一步时可以省略的，下边进入循环的条件就是节点不为空
		// 为了更好理解解题思路
		// 当 root 根为空，没必要继续，直接返回空 list
		if (root == null) {
			return res;
		}

		// 记录当前节点位置
		TreeNode cur = root;

		while(cur != null) {

			// 如果左子树节点为空， 将当前节点 val 添加到结果集 `res` 中，`cur` 指向其右子树 `right` 节点 （cur = cur.right）
			if(cur.left == null) {
				res.add(cur.val);
				cur = cur.right;
			} else {

				// 如果左子树不为空， 找 predecessor 节点
				TreeNode predecessor = cur.left;
				while (predecessor.right != null && predecessor.right != cur) {
					predecessor = predecessor.right;
				}

				// 下面对应描述中的 2 种场景
				// predecessor.right 为空
				if (predecessor.right == null) {
					predecessor.right = cur;
					cur = cur.left;
				} else {
					// 不为空时,进行 3 个操作，对应描述
					res.add(cur.val);
					predecessor.right = null;
					cur = cur.right;
				}
			}
		}

		// 返回结果
		return res;
	}
}