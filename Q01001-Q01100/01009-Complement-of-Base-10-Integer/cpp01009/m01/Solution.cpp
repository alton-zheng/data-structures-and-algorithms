// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Complement of Base 10 Integer.
// Memory Usage: 6 MB, less than 44.81% of C++ online submissions for Complement of Base 10 Integer.
class Solution {
public:
    int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        unsigned int mask = ~0;
        while (mask & n) {
            mask <<= 1;
        }

        return ~mask ^ n;
    }
};