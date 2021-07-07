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

 Runtime: 8 ms, faster than 95.13% of C++ online submissions for Convert Sorted Array to Binary Search Tree.
 Memory Usage: 21.4 MB, less than 42.37% of C++ online submissions for Convert Sorted Array to Binary Search Tree.
 */
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return inorder(nums, 0, nums.size() - 1);
    }

private:
 TreeNode inorder(vector<int>& nums, int left, int right) {

        // 当 left > right 时，当前树完成
        if (left > right) {
            return nullptr;
        }

        // 选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root -> left = inorder(nums, left, mid - 1);
        root -> right = inorder(nums, mid + 1, right);
        return root;
    }
};