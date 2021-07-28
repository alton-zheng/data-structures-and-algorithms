/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sum of Left Leaves.
 Memory Usage: 13.2 MB, less than 96.92% of C++ online submissions for Sum of Left Leaves.
 */
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
// 为了更好的理解,分步写

        // 将空节点排除
        if (root == nullptr) {
            // 默认 null 节点和为 0
            return 0;
        }

        int leftLeafValue = 0;
        // left leaf 值
        if (isLeftLeafNode(root)) {
            leftLeafValue  = root -> left -> val;
        }

        // left 树中 left leaf 值总和
        int l = sumOfLeftLeaves(root -> left);

        // right 树中 left leaf 值总和
        int r = sumOfLeftLeaves(root -> right);

        // 返回总和即可
        return leftLeafValue + l + r;

    }

private:
    bool isLeftLeafNode(TreeNode* node) {

        // 是否 left leaf 节点，需要满足 2 条件
        // 1. 当前节点的 left 节点不为空 2. left 节点不再有左右子节点
        if (node -> left != nullptr &&
                node -> left -> left == nullptr &&
                node -> left -> right == nullptr
        ) {
            return true;
        }

        // 其它情况均为 false
        return false;
    }

};