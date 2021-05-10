/// Source : https://leetcode.com/problems/leaf-similar-trees/description/
/// Author : liuyubobobo
/// Time   : 2018-07-21

#include <iostream>
#include <vector>

using namespace std;

/// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

/// DFS
/// Time Complexity: O(root1.size() + root2.size())
/// Space Complexity: O(root1.size() + root2.size())
class Solution {
public:
    void dfs(TreeNode* node, vector<int>& seq) {
        if (!node->left && !node->right) {
            seq.push_back(node->val);
        }
        else {
            if (node->left) {
                dfs(node->left, seq);
            }
            if (node->right) {
                dfs(node->right, seq);
            }
        }
    }

    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> seq1;
        if (root1) {
            dfs(root1, seq1);
        }

        vector<int> seq2;
        if (root2) {
            dfs(root2, seq2);
        }

        return seq1 == seq2;
    }
};