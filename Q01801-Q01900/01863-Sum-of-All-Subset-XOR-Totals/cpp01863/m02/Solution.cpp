package cpp01863.m02;

// Time Complexity: O(2^N)
// Space Complexity： O(N)

// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sum of All Subset XOR Totals.
// Memory Usage: 7.1 MB, less than 83.35% of C++ online submissions for Sum of All Subset XOR Totals.

class Solution {
public:
    int res;
    int len;

    void dfs(int val, int idx, vector<int>& nums){
        if (idx == len){

            // 当索引刚好等于数组长度时，数组遍历完成
            res += val;
            return;
        }
        // 选择当前元素
        dfs(val ^ nums[idx], idx + 1, nums);
        // 子序列不选择
        dfs(val, idx + 1, nums);
    }

    int subsetXORSum(vector<int>& nums) {
        res = 0;
        len = nums.size();
        dfs(0, 0, nums);
        return res;
    }
};