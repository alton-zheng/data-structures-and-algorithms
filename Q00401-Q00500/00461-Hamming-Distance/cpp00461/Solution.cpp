class Solution {
public:
    int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;

        while (temp != 0) {
            temp &= temp - 1;
            res++;
        }

        return res;
    }
};