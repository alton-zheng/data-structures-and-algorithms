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
    int findTilt(TreeNode* root) {
        //dfs + 后续遍历递归
        LRM(root);

        // 返回坡度和
        return res;
    }

private:
    int res= 0;
    int LRM(TreeNode* node) {

        // 空节点的节点值默认为 0，题目中也有相关介绍，这里不再赘述
        if (node == nullptr) {
            return 0;
        }

        // 递归求当前节点 left 树的节点和
        int l = LRM(node -> left);

        // 递归求当前节点的 right 树的节点和
        int r = LRM(node -> right);

        // 算坡度，并将每个节点的坡度添加到结果 res 中
        res += abs(l - r);

        // 返回当前节点的节点和
        // 对于 root 来说， 其节点和是无意义的，它不再有父节点来用节点和算坡度了
        return l + r + node -> val;

    }
};