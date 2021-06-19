// Runtime: 8 ms, faster than 85.10% of C++ online submissions for Maximum Number of Balls in a Box.
// Memory Usage: 6 MB, less than 72.43% of C++ online submissions for Maximum Number of Balls in a Box.
class Solution {
public:
    int countBalls(int lowLimit, int highLimit) {
        vector<int> help(46);

        int sum;
        for (int i = lowLimit; i < highLimit + 1; i++) {
            sum = 0;
            int cur = i;

            while (cur) {
                sum += cur % 10;
                cur /= 10;
            }

            help[sum]++;
        }

        return *max_element(help.begin(), help.end());

    }
};