

// Runtime: 0 ms, faster than 100.00% of C++ online submissions for N-th Tribonacci Number.
// Memory Usage: 5.8 MB, less than 80.86% of C++ online submissions for N-th Tribonacci Number.

class Solution {
public:
    int tribonacci(int n) {


        int one = 0, two = 1, three = 1;

        if (n < 2) {
            return n;
        }

        if (n == 2) {
            return three;
        }

        int res = 0;
        for (int i = 2; i < n; i++){
            res = one + two + three;
            one = two;
            two = three;
            three = res;
        }

        return res;
    }
};
