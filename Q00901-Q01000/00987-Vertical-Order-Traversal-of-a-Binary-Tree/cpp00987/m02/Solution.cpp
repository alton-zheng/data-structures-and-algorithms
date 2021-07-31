class Solution {
public:
    vector<vector<int>> verticalTraversal(TreeNode* root) {

        /**
         * 定义 vector 数据结构来存储位置信息
         * vector 有个很好的特点，当对它进行排序时，会考虑到里边所有元素，升序遍历
         */
        vector<tuple<int, int,int>> position;

        // 递归相对于迭代，Morris 写法更优雅，这里选择它
        // 可以更好的理解这道题
        // root 树， 按题意 row, col 坐标都为 0， 第三个参数传 postion
        dfs(root, 0, 0, position);

        // 排序结果
        sort(position.begin(), position.end());

        // 递归完后，定义 res 变量
        vector<vector<int>> res(abs(maxCol - minCol) + 1);

        // 因为 position 已经全局排序， 按 col -> row -> val 的优先级已经排序，
        // 不断的添加元素即可
        for(auto& [col, row, val]: position){
            res[col - minCol].push_back(val);
        }
        return res;
    }

private:
    int minCol = 0, maxCol = 0;
    void dfs(TreeNode* node, int row, int col, vector<tuple<int, int,int>>& position){

        // 节点为空时，没意义，直接返回
        if(node == nullptr) {
            return;
        }

        // 求最小最大列
        minCol = min(col, minCol);
        maxCol = max(col, maxCol);

        // 按 col, row ，val 的顺序添加进 postion
        position.push_back({col, row, node -> val});

        // 递归遍历 node left
        dfs(node -> left, row + 1, col - 1,  position);
        // 递归遍历 node right
        dfs(node -> right, row + 1, col + 1, position);
    }
};