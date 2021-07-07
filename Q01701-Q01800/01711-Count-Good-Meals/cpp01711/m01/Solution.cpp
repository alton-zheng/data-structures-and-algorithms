// Runtime: 140 ms, faster than 98.39% of C++ online submissions for Count Good Meals.
// Memory Usage: 249.1 MB, less than 5.14% of C++ online submissions for Count Good Meals.
class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        int mod = 1000000007;

         int m = 0;

         // 找到 deliciousness 中的最大值
         for (int val : deliciousness) {
             m = max(m, val);
         }

         // 每组餐的最大美味度 = m * 2;
         int maxSum = m * 2;
         int pairs = 0;

         // 为了防止数组越界， 加上 m 值，后续使用时，相应的加上 m 即可
         vector<int> help(maxSum + m + 1);

         int n = deliciousness.size();

         for (int i = 0; i < n; i++) {
             int val = deliciousness[i];
             int x = 1;
             while ((val - x) > 0) {
                 x <<= 1;
             }
             for (int sum = x; sum <= maxSum; sum <<= 1) {
                 int count = help[sum - val + m];
                 pairs = (pairs + count) >= mod ? (pairs + count) % mod : (pairs + count);
             }

             help[val + m]++;
         }

         return pairs;
    }
};