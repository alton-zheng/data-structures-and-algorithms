// Runtime: 4 ms, faster than 68.62% of C++ online submissions for 1-bit and 2-bit Characters.
// Memory Usage: 9.8 MB, less than 12.72% of C++ online submissions for 1-bit and 2-bit Characters.
class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {

        int index = bits.size() - 2;

        while (index >= 0 && bits[index] > 0) {
            index++;
        }

        return (bits.size() - index) % 2 == 0;
    }
};