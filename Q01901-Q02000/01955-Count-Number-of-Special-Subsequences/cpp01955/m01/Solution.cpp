// Runtime: 172 ms, faster than 100.00% of C++ online submissions for Count Number of Special Subsequences.
// Memory Usage: 172.2 MB, less than 100.00% of C++ online submissions for Count Number of Special Subsequences.
class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {

        int MOD = 1000000007;
        int zero = 0, one = 0, two = 0;

        for (int i = 0; i < nums.size(); i++) {
            int cur = nums[i];

            if (cur == 0) {
                zero = ((2*zero) %MOD + 1)%MOD;
                continue;
            }

            if (cur == 1) {
                one = (zero  + (2*one)%MOD ) %MOD;
            }

            if (cur == 2) {
                two = (one + (2*two)%MOD)%MOD;
            }
        }

        return two;
    }
};