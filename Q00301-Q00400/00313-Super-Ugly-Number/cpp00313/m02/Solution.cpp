

// Runtime: 96 ms, faster than 58.74% of C++ online submissions for Super Ugly Number.
// Memory Usage: 35.5 MB, less than 33.57% of C++ online submissions for Super Ugly Number.
class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {

            vector<int> dp(n + 1);
            dp[1] = 1;

            int len = primes.size();
            vector<int> pointers(len + 1, 1);

            for (int i = 2; i <= n; i++) {

                vector<int> nums(len + 1);

                int minV = INT_MAX;

                for (int j = 1; j <= len; j++) {
                    nums[j] = dp[pointers[j]] * primes[j - 1];
                    minV = min(minV, nums[j]);
                }

                dp[i] = minV;

                for (int j = 1; j <= len; j++) {
                    if (minV == nums[j]) {
                        pointers[j]++;
                    }
                }
            }

            return dp[n];
    }
};