// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Path Crossing.
// Memory Usage: 6.9 MB, less than 37.11% of C++ online submissions for Path Crossing.
class Solution {
public:
    bool isPathCrossing(string path) {
        unordered_set<int> help;

        int x = 0, y = 0;
        help.insert(0);

        for (char c: path) {
            switch(c) {
                case 'E': x++; break;
                case 'S': y--; break;
                case 'W': x--; break;
                case 'N': y++; break;
            }

            int value = x * 20001 + y;
            if (help.find(value) != help.end()) {
                return true;
            } else {
                help.insert(value);
            }
        }

        return false;

    }
};