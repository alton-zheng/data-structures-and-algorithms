// Runtime: 4 ms, faster than 71.50% of C++ online submissions for Check if the Sentence Is Pangram.
// Memory Usage: 6.5 MB, less than 63.15% of C++ online submissions for Check if the Sentence Is Pangram.
class Solution {
public:
    bool checkIfPangram(string sentence) {
        if (sentence.size() < 26) {
            return false;
        }

        vector<int> res(26);

        for (int i = 0; i < sentence.size(); i++) {
            res[sentence[i] - 'a']++;
        }

        for (int i : res) {
            if (i == 0) {
                return false;
            }
        }

        return true;
    }
};