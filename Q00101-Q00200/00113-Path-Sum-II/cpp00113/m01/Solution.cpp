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
 */
class Solution {

private:
    vector<vector<int>> res;
    vector<int> temp;
    int target;

    void dfs(TreeNode* node, int sum) {
        if (node == nullptr) {
            return;
        }

        temp.push_back(node -> val);
        if (node -> left == nullptr && node -> right == nullptr && sum + node -> val == target) {
            res.push_back(temp);
        }

        dfs(node -> left, sum + node -> val);
        dfs(node -> right, sum + node -> val);

        temp.pop_back();
    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        target = targetSum;
        dfs(root, 0);
        return res;
    }

};