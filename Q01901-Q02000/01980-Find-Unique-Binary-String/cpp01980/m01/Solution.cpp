// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Find Unique Binary String.
// Memory Usage: 10.3 MB, less than 40.00% of C++ online submissions for Find Unique Binary String.
class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {

        int len = nums.size();

        unordered_set<int> help;
        for (const string& num: nums){
            help.insert(stoi(num, nullptr, 2));
        }

        int res = 0;

        while (help.count(res)) {
            res++;
        }

        return bitset<16>(res).to_string().substr(16 - len, 16);
    }
};
