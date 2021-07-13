// Runtime: 28 ms, faster than 21.61% of C++ online submissions for Reconstruct Original Digits from English.
// Memory Usage: 8.8 MB, less than 79.17% of C++ online submissions for Reconstruct Original Digits from English.
class Solution {
public:
    string originalDigits(string s) {
        // building hashmap letter -> its frequency
        vector<int> help((int)'a' + 26, 0);
        for(char letter: s) {
            help[letter]++;
        }

        // building hashmap digit -> its frequency
        vector<int> ten(10, 0);
        // letter "z" is present only in "zero"
        ten[0] = help['z'];
        // letter "w" is present only in "two"
        ten[2] = help['w'];
        // letter "u" is present only in "four"
        ten[4] = help['u'];
        // letter "x" is present only in "six"
        ten[6] = help['x'];
        // letter "g" is present only in "eight"
        ten[8] = help['g'];
        // letter "h" is present only in "three" and "eight"
        ten[3] = help['h'] - ten[8];
        // letter "f" is present only in "five" and "four"
        ten[5] = help['f'] - ten[4];
        // letter "s" is present only in "seven" and "six"
        ten[7] = help['s'] - ten[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        ten[9] = help['i'] - ten[5] - ten[6] - ten[8];
        // letter "n" is present in "one", "nine", and "seven"
        ten[1] = help['n'] - ten[7] - 2 * ten[9];

        // building output string
        string res;
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < ten[i]; j++) {
                res +=  to_string(i);
            }
        }
        return res;
    }
};