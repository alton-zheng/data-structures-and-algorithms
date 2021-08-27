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
 Runtime: 4 ms, faster than 73.91% of C++ online submissions for Binary Tree Paths.
 Memory Usage: 14 MB, less than 9.05% of C++ online submissions for Binary Tree Paths.
 */
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {

        dfs(root, "");
        return res;
    }

private:
    vector<string> res;
    void dfs(TreeNode* node, string s) {

        if (node == nullptr) {
            return;
        }

        if (s == "") {
            s += to_string(node -> val);
        } else {
            s += "->" + to_string(node -> val);
        }

        if (node -> left == nullptr && node -> right == nullptr) {

            res.push_back(s);
        }

        dfs(node -> left, s);
        dfs(node -> right, s);
    }
};