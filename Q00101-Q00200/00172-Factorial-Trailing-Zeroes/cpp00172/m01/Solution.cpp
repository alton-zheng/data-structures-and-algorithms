// Runtime: 4 ms, faster than 21.88% of C++ online submissions for Factorial Trailing Zeroes.
// Memory Usage: 5.9 MB, less than 25.09% of C++ online submissions for Factorial Trailing Zeroes.
// Time Complexity : O(N)
// Space Complexity : O(1)
lass Solution {
public:
    int trailingZeroes(int n) {

        int res = 0;

        for (int i = 5; i < n + 1; i += 5) {
            int power5 = 5;
            while (i % power5 == 0) {
                res++;
                power5 *= 5;
            }
        }

        return res;

    }
};