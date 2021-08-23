class Solution {
public:
    int getMaximumGenerated(int n) {

        if (n == 0) {
            return 0;
        }
        vector<int> help(n + 1);
        help[1] = 1;

        for (int i = 2; i <= n; i++) {
            help[i] = help[i / 2] + i % 2 * help[i / 2 + 1];
        }

        return *max_element(help.begin(), help.end());
    }
};