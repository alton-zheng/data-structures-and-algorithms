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
public:
    unordered_map<long long, int> prefix;
    int target;

    int dfs(TreeNode *root, long long curr) {
        if (!root) {
            return 0;
        }

        int ret = 0;
        curr += root -> val;
        if (prefix.count(curr - target)) {
            ret = prefix[curr - target];
        }
    
        
        prefix[curr]++;
        ret += dfs(root->left, curr);
        ret += dfs(root->right, curr);
        prefix[curr]--;

        return ret;
    }

    int pathSum(TreeNode* root, int targetSum) {
        prefix[0] = 1;
        this -> target = targetSum;
        return dfs(root, 0);
    }
};