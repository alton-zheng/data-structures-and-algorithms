// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Second Minimum Node In a Binary Tree.
// Memory Usage: 7.1 MB, less than 21.05% of C++ online submissions for Second Minimum Node In a Binary Tree.
class Solution {
public:
    int findSecondMinimumValue(TreeNode* root) {
        int res = -1;
        int minValue = root -> val;

        function<void(TreeNode*)> dfs = [&](TreeNode* node) {

            if (!node) {
                return;
            }

            if (res != -1 && node -> val >= res) {
                return;
            }

            if (node -> val > minValue) {
                res = node -> val;
            }

            dfs(node -> left);
            dfs(node -> right);
        };

        dfs(root);
        return res;
    }
};