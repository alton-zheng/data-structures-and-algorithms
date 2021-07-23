// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Latest Time by Replacing Hidden Digits.
// Memory Usage: 5.8 MB, less than 62.63% of C++ online submissions for Latest Time by Replacing Hidden Digits.
class Solution {
public:
    string maximumTime(string time) {

        time[0] = time[0] != '?' ? time[0] : ((time[1] != '?' && time[1] >= '4') ? '1' : '2');

        time[1] = time[1] != '?' ? time[1] : ((time[0] == '2') ? '3' : '9');

        time[3] = time[3] != '?' ? time[3] : '5';

        time[4] = time[4] != '?' ? time[4] : '9';

        return time;
    }
};