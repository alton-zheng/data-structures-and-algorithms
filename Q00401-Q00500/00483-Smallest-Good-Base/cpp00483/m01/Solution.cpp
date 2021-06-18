// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Smallest Good Base.
// Memory Usage: 6.4 MB, less than 25.36% of C++ online submissions for Smallest Good Base.
class Solution {
public:
    string smallestGoodBase(string n) {

        // define 1..1 (m + 1 len)
        // (11...11)k = k^0 + k^1 + ... + k^{m - 1} + k^{m} = n
        // m < log_2 * 10^{18} < 60
        // k^m < n < (k+1)^m
        // k < n^{1/m} < k+1

        // string n -> long nVal
        long nVal = stol(n);

        // get max(m)
        int mMax = floor(log(nVal) / log(2));

        for (int m = mMax; m > 1; m--) {
            int k = pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;

            for (int i = 1; i < m + 1; i++) {
                mul *= k;
                sum += mul;
            }

            if (sum == nVal) {
                return to_string(k);
            }
        }

        return to_string(nVal - 1);
    }
};