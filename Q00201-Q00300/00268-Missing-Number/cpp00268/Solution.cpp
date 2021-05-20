class Solution {

public:
    int missingNumber(vector<int> nums){
        int numsLen = nums.size();

        int res = 0;
        int count = 0;
        for (int i = 0; i < numsLen; i++) {
            count += nums[i];
            res += i;
        }

        return res + numsLen - count;
    }
};