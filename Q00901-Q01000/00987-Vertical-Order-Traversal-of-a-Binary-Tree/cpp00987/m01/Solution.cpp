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
    vector<vector<int>> verticalTraversal(TreeNode* root) {

        /**
         * 定义 map 数据结构来存储位置信息
         *
         * key 为 col 属性，与结果集中维度信息相称
         * 在 c++ 中 map 结构已经为 col 默认升序了
         * value 为 多个「row, val」 对
         */
        map<int, vector<pair<int, int>>> position;

        // 递归相对于迭代，Morris 写法更优雅，这里选择它
        // 可以更好的理解这道题
        // root 树， 按题意 row, col 坐标都为 0， 第三个参数传 postion
        dfs(root, 0, 0, position);

        // 递归完后，定义 res 变量
        vector<vector<int>> res;

        // 遍历 postion
        for(pair<int, vector<pair<int, int>>> p: position){
            // 按 row 排序
            sort(p.second.begin(), p.second.end());
            vector<int> cur;
            for(const pair<int, int>& x: p.second)
                cur.push_back(x.second);
            res.push_back(cur);
        }
        return res;
    }

private:
    void dfs(TreeNode* node, int row, int col, map<int, vector<pair<int, int>>>& position){

        // 节点为空时，没意义，直接返回
        if(node == nullptr) {
            return;
        }

        // 将 row ， node val 信息添加到 col 信息中
        position[col].push_back({row, node->val});
        // 递归遍历 node left
        dfs(node->left, row + 1, col - 1,  position);
        // 递归遍历 node right
        dfs(node->right, row + 1, col + 1, position);
    }
};