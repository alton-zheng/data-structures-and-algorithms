// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Last Stone Weight II.
// Memory Usage: 8.4 MB, less than 33.50% of C++ online submissions for Last Stone Weight II.
class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {

        int sum = accumulate(stones.begin(), stones.end(), 0);

        int bun = sum / 2;
        vector<int> help(bun + 1);
        help[0] = true;

        for (int stoneWeight: stones) {
            for (int w = bun; w >= stoneWeight; w--) {
                help[w] = help[w] || help[w - stoneWeight];
            }
        }

        for (int w = bun; ;w--) {
            if (help[w]) {
                return sum - 2*w;
            }
        }
    }
};