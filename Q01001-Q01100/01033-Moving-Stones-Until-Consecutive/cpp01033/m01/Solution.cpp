// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Moving Stones Until Consecutive.
// Memory Usage: 6.4 MB, less than 10.73% of C++ online submissions for Moving Stones Until Consecutive.
class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {

        if (a > b) {
            swap(a, b);
        }
        if (a > c) {
            swap(a, c);
        }
        if (b > c) {
            swap(b, c);
        }

        return {b - a - 1 == 0 && c - b - 1 == 0 ? 0 : b - a > 2 && c - b  > 2 ? 2 : 1, c - a - 2};
    }
};