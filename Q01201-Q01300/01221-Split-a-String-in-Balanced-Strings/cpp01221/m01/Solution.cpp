class Solution {
public:
    int balancedStringSplit(string s) {

        int res = 0;
        int flag = 0;

        for (char c: s) {
            if (c == 'R') {
                flag--;
            } else {
                flag++;
            }

            if (flag == 0) {
                res++;
            }
        }

        return res;
    }
};