// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Number of Digit One.
// Memory Usage: 6 MB, less than 50.98% of C++ online submissions for Number of Digit One.
class Solution {
public:
    int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到 （都是使用  10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; k++) {

            ans += (n / (mulk * 10)) * mulk + min(max(n % (mulk * 10) - mulk + 1, 0LL), mulk);
            // 10^k
            mulk *= 10;
        }

        return ans;
    }
};