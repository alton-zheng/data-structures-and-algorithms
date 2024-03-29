// 迭代模拟递归，与方法一效果相同的
// Runtime: 20 ms, faster than 50.30% of C++ online submissions for Binary Tree Tilt.
// Memory Usage: 24.4 MB, less than 6.50% of C++ online submissions for Binary Tree Tilt.
class Solution {
public:
    int findTilt(TreeNode* root) {

        // 节点为空时，树坡度为 0
        if (root == nullptr) {
            return 0;
        }

        // 定义迭代 stk
        stack<TreeNode*> stk;

        // 记录整棵树入栈的顺序, 这里注意了
        vector<TreeNode*> trees;

        // 先将 root 节点入栈
        stk.emplace(root);

        // 栈不为空，处理
        // 将整棵树所有节点按 left, right 的顺序入栈
        while (!stk.empty()) {

            // 首先从栈中取出当前的树节点
            TreeNode* treeNode = stk.top();
            stk.pop();

            // 将从栈中取出的树节点，放入到 trees 中，
            // 后添加的放在首元素，后面的节点位置相应的后移
            trees.push_back(treeNode);

            // 先将当前节点的子树 left -> right 入栈（后续迭代）
            // left 不为空才有意义
            if (treeNode -> left != nullptr) {
                // left 压栈
                stk.emplace(treeNode -> left);
            }

            // right 不为空才有意义
            if (treeNode -> right != nullptr) {

                // right 入栈
                stk.emplace(treeNode -> right);

            }
        }

        // 到这里为栈，栈功成身退，后面只需要处理每颗树的 val 即可， 从整棵树的底部到顶部依次进行处理

        // 定义总坡度变量,也就是结果
        int res = 0;
        // 遍历 trees ,这时候的 treeNode，
        for (int i = trees.size() - 1; i >= 0; i--) {
            // 当前树的 left 树的 val, 为空时，默认 0， 不为空时，取其值
            int left = trees[i] -> left == nullptr ? 0 : trees[i] -> left -> val;

            // 当前树的 right 树的 val，为空时，默认 0， 不为空，取其值
            int right = trees[i] -> right == nullptr ? 0 : trees[i] -> right -> val;

            // 将当前树的节点 val, 赋值为当前数所有节点和
            // 与递归方法中，LRM 方法返回值的用法一样的效果，没有区别，在 LRM 中也可以这样处理
            // 当这里不能根递归方法中处理一样返回，这里没有回调这些返回值的地方
            // 将节点值进行更新，称为后序遍历处理此问题的思路和方法
            trees[i] -> val = left + right + trees[i] -> val;

            // 回到题目，利用left, right 总值计算坡度值，并将当前树的坡度值添加到 res 中
            res += abs(left - right);

        }

        // 返回结果值即可
        return res;
    }
};