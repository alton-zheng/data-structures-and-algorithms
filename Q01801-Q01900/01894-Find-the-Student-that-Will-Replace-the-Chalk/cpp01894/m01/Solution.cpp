class Solution {
public:
    int chalkReplacer(vector<int>& chalk, int k) {

        int len = chalk.size();

        vector<long> help(len + 1);

        for (int i = 1; i <= len; i++) {
            help[i] = help[i - 1] + chalk[i - 1];
        }

        int find = k % help[len];

        if (find == 0) {
            return 0;
        }

        int left = 0, right = len;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (help[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;


    }
};