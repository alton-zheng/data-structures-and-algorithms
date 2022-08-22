# 654 最大二叉树

## 描述

给定一个不重复的整数数组 `nums` 。 **最大二叉树** 可以用下面的算法从 `nums` 递归地构建:

1. 创建一个根节点，其值为 `nums` 中的最大值。
2. 递归地在最大值 **左边** 的 **子数组前缀上** 构建左子树。
3. 递归地在最大值 **右边** 的 **子数组后缀上** 构建右子树。

返回 *`nums` 构建的*  最大二叉树。

 

**示例 1：**

![img](tree1.png)

输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：

- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
  - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
    - 空数组，无子节点。
    - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
      - 空数组，无子节点。
      - 只有一个元素，所以子节点是一个值为 1 的节点。
  - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
    - 只有一个元素，所以子节点是一个值为 0 的节点。
    - 空数组，无子节点。

&nbsp;

**示例 2：**

![img](tree2.png)

> 输入：nums = [3,2,1]
> 输出：[3,null,2,null,1]

 

&nbsp;



**提示：**

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 1000`
- `nums` 中的所有整数 **互不相同**

&nbsp;

## 递归模拟

》 这种方法符合题意， 递归处理

一棵 tree, 由 root 节点 和 left tree, right tree 组成

- 既然是递归，毫无疑问每次递归需要将递归范围内的 max 值作为当前树的 root 根节点值
- 然后从递归范围中找到一个切割点，来分割 left, right
  - 既然 root 节点已经在之前的步骤中确认，那么由它分割最为合适。

> 考虑边界条件，什么场景下无法成 tree 呢？ 
>
> 数据源是 nums 数组，那么我们分割的 left, right 无法形成一个子集时，就无法成 tree
>
> - 也就是 index , left > right 
>
> 到这为止，应该理解了吧。 

&nbsp;

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    // 进入递归， 全数组
    return MBT(nums, 0, nums.length - 1);
  }
  
  private TreeNode MBT(int[] nums, int l, int r) {
    
    // 边界场景
    if (l > r) {
      return null;
    }
    
    // 定义最大值 index 变量, 初始化为一个值，这里选择 l
    // 它必须是数组 [l,r]
    int mVIndex = l;
    
    for (int i = l + 1; i <= r; i++) {
     
      // 找到 nums,  [l, r]  范围内最大值所在 index , 作为 mVIndex
      if (nums[i] > nums[mVIndex]) {
        mVIndex = i;
      }
    }
    
    // 返回当前范围 root 为 nums[mVIndex] 的树
    return new TreeNode(
      nums[mVIndex],
      MBT(nums, l, mVIndex - 1),
      MBT(nums, mVIndex + 1, r)
    );
    
  }
}
```

&nbsp;

时间复杂度： O(N^2)

空间复杂度： O(N)



&nbsp;

思路与算法

我们可以将题目中构造树的过程等价转换为下面的构造过程：

初始时，我们只有一个根节点，其中存储了整个数组；

在每一步操作中，我们可以「任选」一个存储了超过一个数的节点，找出其中的最大值并存储在该节点。最大值左侧的数组部分下放到该节点的左子节点，右侧的数组部分下放到该节点的右子节点；

如果所有的节点都恰好存储了一个数，那么构造结束。

由于最终构造出的是一棵树，因此无需按照题目的要求「递归」地进行构造，而是每次可以「任选」一个节点进行构造。这里可以类比一棵树的「深度优先搜索」和「广度优先搜索」，二者都可以起到遍历整棵树的效果。

既然可以任意进行选择，那么我们不妨每次选择数组中最大值最大的那个节点进行构造。这样一来，我们就可以保证按照数组中元素降序排序的顺序依次构造每个节点。因此：

当我们选择的节点中数组的最大值为 \textit{nums}[i]nums[i] 时，所有大于 \textit{nums}[i]nums[i] 的元素已经被构造过（即被单独放入某一个节点中），所有小于 \textit{nums}[i]nums[i] 的元素还没有被构造过。

这就说明：

在最终构造出的树上，以 \textit{nums}[i]nums[i] 为根节点的子树，在原数组中对应的区间，左边界为 \textit{nums}[i]nums[i] 左侧第一个比它大的元素所在的位置，右边界为 \textit{nums}[i]nums[i] 右侧第一个比它大的元素所在的位置。左右边界均为开边界。

如果某一侧边界不存在，则那一侧边界为数组的边界。如果两侧边界均不存在，说明其为最大值，即根节点。

并且：

\textit{nums}[i]nums[i] 的父结点是两个边界中较小的那个元素对应的节点。

因此，我们的任务变为：找出每一个元素左侧和右侧第一个比它大的元素所在的位置。这就是一个经典的单调栈问题了，可以参考 503. 下一个更大元素 II。如果左侧的元素较小，那么该元素就是左侧元素的右子节点；如果右侧的元素较小，那么该元素就是右侧元素的左子节点。

代码

```java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        TreeNode root = null;
        for (int i = 0; i < n; ++i) {
            if (left[i] == -1 && right[i] == -1) {
                root = tree[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                tree[left[i]].right = tree[i];
            } else {
                tree[right[i]].left = tree[i];
            }
        }
        return root;
    }
}
我们还可以把最后构造树的过程放进单调栈求解的步骤中，省去用来存储左右边界的数组。下面的代码理解起来较为困难，同一个节点的左右子树会被多次赋值，读者可以仔细品味其妙处所在。
```
```java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        List<Integer> stack = new ArrayList<Integer>();
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.get(stack.size() - 1)]) {
                tree[i].left = tree[stack.get(stack.size() - 1)];
                stack.remove(stack.size() - 1);
            }
            if (!stack.isEmpty()) {
                tree[stack.get(stack.size() - 1)].right = tree[i];
            }
            stack.add(i);
        }
        return tree[stack.get(0)];
    }
}
```

复杂度分析

时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{nums}nums 的长度。单调栈求解左右边界和构造树均需要 O(n)O(n) 的时间。

空间复杂度：O(n)O(n)，即为单调栈和数组 \textit{tree}tree 需要使用的空间。
