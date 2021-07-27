# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Runtime: 32 ms, faster than 92.83% of Python3 online submissions for Sum of Root To Leaf Binary Numbers.
# Memory Usage: 14.6 MB, less than 68.04% of Python3 online submissions for Sum of Root To Leaf Binary Numbers.
def pre_order(node, parent_sum):

    # 初始化 sum 值
    sum = 0

    # 节点为空，直接返回 sum
    if node == None:
        return sum

    cur = (parent_sum << 1) | node.val
    if node.left == None and node.right == None:
        #  leaf 节点，将 cur 添加到 sum
        sum += cur
        # 直接返回，不需要后续操作
        return sum

    # 返回 left, right
    sum += pre_order(node.left, cur)
    sum += pre_order(node.right, cur)

    # 返回结果
    return sum


class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        return pre_order(root, 0)