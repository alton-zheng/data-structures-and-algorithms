// Runtime: 20 ms, faster than 53.74% of C++ online submissions for Minimum Absolute Difference in BST.
// Memory Usage: 25.2 MB, less than 74.43% of C++ online submissions for Minimum Absolute Difference in BST.
class Solution {
private:
    int res = 10001;
    int pre = -1;
    void dfs(TreeNode* node) {

        if (node == nullptr) {
            return;
        }

        dfs(node -> left);

        if (pre == -1) {
            pre = node -> val;
        } else {
            res = min(res, node -> val - pre);
            pre = node -> val;
        }

        dfs (node -> right);
    }

public:
    int getMinimumDifference(TreeNode* root) {
        dfs(root);
        return res;
    }
};