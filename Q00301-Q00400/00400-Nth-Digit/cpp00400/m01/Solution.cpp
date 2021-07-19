// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Nth Digit.
// Memory Usage: 5.8 MB, less than 85.50% of C++ online submissions for Nth Digit.
class Solution {
public:
    int findNthDigit(int n) {
        long base = 9, dig = 1;
        int num;
        while(n > base * dig){
            n -= base * dig;
            num += base;
            base *= 10;
            dig++;
        }

        num += (n-1) / dig + 1;
        int idx = (n-1) % dig + 1;
        while(dig-- > idx)
            num /= 10;
        return num % 10;
    }
};