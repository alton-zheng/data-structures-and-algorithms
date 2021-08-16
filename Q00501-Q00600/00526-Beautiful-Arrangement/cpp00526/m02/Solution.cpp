

class Solution {
public:
    int countArrangement(int n) {

        vector<int> help(1 << n);

        help[0] = 1;

        for(int m = 1; m < (1 << n); m++) {

            int num = __builtin_popcount(m);

            for (int i = 0; i < n; i++) {
                if (m & (1 << i) && (num % (i + 1) == 0 || (i + 1) % num == 0)) {
                    help[m] += help[m ^ (1 << i)];
                }
            }

        }

        return help[(1 << n) - 1];
    }
};