// Runtime: 88 ms, faster than 27.41% of C++ online submissions for Hand of Straights.
// Memory Usage: 26.3 MB, less than 48.11% of C++ online submissions for Hand of Straights.
class Solution {
public:
    bool isNStraightHand(vector<int>& hands, int groupSize) {

        map<int, int> help;

        for(int num: hands) {
            help[num]++;
        }

        for (auto iter = help.begin(); iter != help.end(); iter++) {
            int num = iter -> first;
            int acc = iter -> second;

            if (acc > 0) {

                auto it = next(iter);

                for (int i = 1; i < groupSize; i++,it++) {
                    if (it != help.end() && it -> first == num + i && it -> second > acc - 1) {
                        it -> second -= acc;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;

    }
};