class Solution {
public:
    int fib(int n) {
        long first = 0, second = 1;
        int mod = 1000000007;
        if (n < 2) {
            return n;
        }

        long res = 0;

        for (int i = 2; i <= n; i++) {
            res = (second + first) % mod;
            first = second;
            second = res;
        }

        return res;
    }
};