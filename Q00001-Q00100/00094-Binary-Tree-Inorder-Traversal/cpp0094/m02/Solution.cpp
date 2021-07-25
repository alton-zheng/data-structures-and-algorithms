// 迭代模拟递归，与方法一效果相同的
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {

        // 定义结果
        vector<int> res;

        // 定义 stack
        stack<TreeNode*> stk;

        while(root != nullptr || !stk.empty()) {

            // 由于是中序遍历,首先将当前节点所有左子树压栈
            while (root != nullptr) {
                stk.push(root);
                root = root -> left;
            }

            // 从栈中去除一个 TreeNode
            root = stk.top();
            stk.pop();

            // 将 TreeNode 元素添加到 结果集中
            res.push_back(root -> val);

            // 将树的右子树置于当前节点
            root = root -> right;
        }

        return res;
    }
};