/// Source : https://leetcode.com/problems/longest-common-prefix/description/
/// Author : liuyubobobo
/// Time   : 2018-06-03

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

/// Horizonal Scan
/// Time Complexity: O(len(strs) * max len of string)
/// Space Complexity: O(1)

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (!strs.size()) {
            return "";
        }

        string prefix = strs[0];
        int count = strs.size();
        for (int i = 1; i < count; ++i) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (!prefix.size()) {
                break;
            }
        }

        return prefix;
    }

    string longestCommonPrefix(const string& str1, const string& str2) {

        int length = min(str1.size(), str2.size());
        int index = 0;
        while (index < length && str1[index] == str2[index]) {
            ++index;
        }
        return str1.substr(0, index);
    }
};

int main() {

    vector<string> strs1 = {"flower","flow","flight"};
    cout << Solution().longestCommonPrefix(strs1) << endl;

    vector<string> strs2 = {"dog","racecar","car"};
    cout << Solution().longestCommonPrefix(strs2) << endl;

    return 0;
}