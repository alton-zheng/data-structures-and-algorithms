/*

*/
class Solution {
public:
    string reverseVowels(string s) {

        vector<int> help(128, 0);

        string vowels = "aoiueAOIUE";
        for (int i = 0; i < vowels.size(); i++) {
            help[vowels[i]]++;
        }

        int len = s.size();
        if (len == 1) {
            return s;
        }

        int left = 0; int right = len - 1;

        while (left < right) {
            while (left < len - 1 && !help[s[left]]) {
                left++;
            }

            while (right > 0 && !help[s[right]]) {
                right--;
            }

            if (left < right) {
                swap(s[left], s[right]);
            }


            left++;
            right--;
        }

        return s;
    }
};