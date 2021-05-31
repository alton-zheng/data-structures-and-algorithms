class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {

        vector<int> res;

        for (int i = left, j = 0; i < right + 1; i++) {
            for (j = i; j > 0; j /= 10) {
                if (!(j % 10) || i % (j % 10)) {
                    break;
                }
            }

            if (!j) {
                res.push_back(i);
            }

        }

        return res;
    }
};