class Solution {
    public:
        int maxNumberOfBalloons(string text) {
            vector<int> count(5);

            for (auto & c: text) {
                if (c == 'b') {
                    count[0]++;
                } else if (c == 'a') {
                    count[1]++;
                } else if (c == 'l') {
                    count[2]++;
                } else if (c == 'o') {
                    count[3]++;
                } else if (c == 'n') {
                    count[4]++;
                }
            }

            count[2] /= 2;
            count[3] /= 2;

            return *min_element(count.begin(), count.end());
        }
};