class Solution {
public:
    int findIntegers(int n) {

        vector<int> help(31);
        help[0] = help[1] = 1;

        for (int i = 2; i < 31; i++) {
            help[i] = help[i - 1] + help[i - 2];
        }


        int pre = 0, res = 0;
        for (int i = 29; i >= 0; i--){
            int cur = 1 << i;
            if ((cur & n) != 0) {
                res += help[i + 1];
                if (pre == 1) {
                    break;
                }

                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                res++;
            }
        }

        return res;
    }
};