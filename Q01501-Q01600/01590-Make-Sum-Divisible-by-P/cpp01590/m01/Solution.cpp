// Runtime: 168 ms, faster than 94.71% of C++ online submissions for Make Sum Divisible by P.
// Memory Usage: 69.9 MB, less than 21.06% of C++ online submissions for Make Sum Divisible by P.
class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        long sum = 0;

        for (int num: nums) {
            sum += num;
        }

        long mod = sum % p;
        if (mod == 0) {
            return 0;
        }

        unordered_map<long, int> help;
        help[0] = -1;

        long curMod = 0;
        int res = nums.size();
        for(int i = 0; i < nums.size(); i++){

            curMod = (curMod + nums[i]) % p;
            long target  = (curMod - mod + p) % p;
            if(help.count(target)){
                res = min(res, i - help[target]);
                if (res == 1 && res != nums.size()) {
                    return res;
                }
            }
            help[curMod] = i;
        }
        return res == nums.size() ? -1 : res;
    }
};