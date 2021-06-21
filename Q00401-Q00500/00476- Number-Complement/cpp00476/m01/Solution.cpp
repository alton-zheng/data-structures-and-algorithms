// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Number Complement.
// Memory Usage: 5.7 MB, less than 99.27% of C++ online submissions for Number Complement.
class Solution {
public:
    int findComplement(int num) {
        unsigned mask = ~0;
        while (num & mask) mask <<= 1;
        return ~mask ^ num;
    }
};