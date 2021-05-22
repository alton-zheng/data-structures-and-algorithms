class Solution {
public:
    bool xorGame(vector<int>& nums) {

        // return (!nums.size() & 1) || !accumulate(nums.start(), nums.end(), 0, bit_xor{});
        return !(nums.size() & 1) || !xors(nums);
    }

    int xors(vector<int>& nums) {
        int x = 0;
        for (int num: nums) {
            x ^= num;
        }

        return x;
    }
};