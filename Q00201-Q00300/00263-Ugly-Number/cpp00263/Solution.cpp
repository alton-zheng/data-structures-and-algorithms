// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Ugly Number.
// Memory Usage: 5.8 MB, less than 83.52% of C++ online submissions for Ugly Number.
class Solution {
public:
    bool isUgly(int n) {

        for (int i = 2; i < 6 && n > 0; i++) {
            while (n % i == 0) {
                n /= i;
            }
        }

        return n == 1;

    }
};