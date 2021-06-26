// Runtime: 4 ms, faster than 95.76% of C++ online submissions for Sort Array by Increasing Frequency.
// Memory Usage: 10.9 MB, less than 96.06% of C++ online submissions for Sort Array by Increasing Frequency.

class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        // 题目中限制了 -100 <= nums[i] <= 100，所以可能取值范围是 [-100, 100]
        vector<int> help(201);

        // 由于数组索引不能为负数，首先遍历数组将元素放入 help 索引范围 [1, 200] 中
        // 并且将每个元素出现的频次存入到数组中
        for (int item : nums){
            help[item + 100]++;
        }

        // 更新原数组：
        // 1 频次越高，更新值越大
        // 2 频次相同，原值越大，更新值越小
        // 以上两者规则刚好符合题意
        for (int i = 0; i < nums.size(); i++){
            nums[i] = 10000 * help[nums[i] + 100] - nums[i] + 100;
        }

        // 将更新后的 nums 升序排序， 刚好将数组按符合题意的顺序进行排列
        sort(nums.begin(), nums.end());

        // 接下来恢复原值即可
        for (int i = 0; i < nums.size(); i ++){
            nums[i] = 100 - nums[i] % 10000;
        }

        return nums;
    }
};