class Solution {
public:
    int countTriplets(vector<int>& arr) {
        int arrLen = arr.size();
        vector<int> help(arrLen + 1);

        for (int i = 0; i < arrLen; i++) {
            help[i + 1] = help[i] ^ arr[i];
        }

        int res = 0;
        for (int i = 0; i < arrLen; i++) {

            for (int k = i + 1; k < arrLen; k++) {
                if (help[i] == help[k+1]) {
                    res += k - i;
                }
            }

        }

        return res;
    }
};
