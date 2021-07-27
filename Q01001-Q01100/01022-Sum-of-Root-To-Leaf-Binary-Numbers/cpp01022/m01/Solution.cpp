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
 Runtime: 4 ms, faster than 87.38% of C++ online submissions for Sum of Root To Leaf Binary Numbers.
 Memory Usage: 16.8 MB, less than 32.20% of C++ online submissions for Sum of Root To Leaf Binary Numbers.
 */
class Solution {
public:
    int sumRootToLeaf(TreeNode* root) {

        // 迭代解法，利用 stk
        queue<TreeNode*> stk;

        // 首先将 root push 进 stk
        stk.push(root);

        // 初始化结果值
        int res = 0;

        // stk 不为空进入迭代
        while(!stk.empty()){

            // 取出节点并删除
            TreeNode* cur = stk.front();
            stk.pop();

            // 当前节点值
            int num = cur -> val;

            // 当 left, right 为空
            if(!cur -> left && !cur -> right){

                // 将 leaf 节点值加到 res 结果中
                // 可能有朋友会认为这里的值少了，其实不然， leaf 值已经在下列逻辑中更新为所有二进制和了。
                res += cur -> val;

                // 下列步骤，需要 left 或 right 不为空，没必要进行判断，进入下一迭代即可
                continue;
            }

            // left 不为空时, 说明 leaf 还未找到，继续
            if(cur -> left){
                // 将 left 节点值更新为二进制和 （与递归中 parSum 用法一致）
                cur -> left -> val = (num << 1) | (cur -> left -> val);

                // 更新 left.val 后将 left 压栈
                stk.push(cur -> left);
            }

            // right 不为空时，说明还未到 leaf
            if(cur -> right){
                // 将 left.val 更新为二进制和 （与递归中 parSum 含义一致）
                cur -> right -> val = (num <<1) | (cur -> right -> val);

                // 更新 right.val 后, 将 right 压栈
                stk.push(cur -> right);
            }

        }
        // 返回 res
        return res;
    }
};