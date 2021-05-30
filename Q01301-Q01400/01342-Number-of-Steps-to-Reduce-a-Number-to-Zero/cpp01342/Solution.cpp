/**
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
Memory Usage: 6 MB, less than 17.55% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
 */
class Solution {
public:
    int numberOfSteps(int num) {
        int res = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                res++;
                num /= 2;
            } else {
                res++;
                num -= 1;
            }
        }

        return res;
    }
};