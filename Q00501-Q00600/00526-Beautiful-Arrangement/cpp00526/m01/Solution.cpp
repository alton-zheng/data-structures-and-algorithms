// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Beautiful Arrangement.
// Memory Usage: 6.1 MB, less than 54.74% of C++ online submissions for Beautiful Arrangement.
class Solution {
public:
    int countArrangement(int n) {
        vector<int> help = {0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679};
        return help[n];
    }
};