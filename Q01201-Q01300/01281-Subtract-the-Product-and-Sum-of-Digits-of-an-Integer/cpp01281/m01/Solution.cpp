// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Subtract the Product and Sum of Digits of an Integer.
// Memory Usage: 6 MB, less than 25.41% of C++ online submissions for Subtract the Product and Sum of Digits of an Integer.
class Solution {
public:
    int subtractProductAndSum(int n) {

        int mul = 1;
        int sum = 0;

        while (n > 0) {
            int cur = n % 10;
            mul *= cur;
            sum += cur;
            n /= 10;
        }

        return mul - sum;

    }
};