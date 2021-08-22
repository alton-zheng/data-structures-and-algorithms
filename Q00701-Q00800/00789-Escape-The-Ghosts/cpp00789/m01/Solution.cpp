class Solution {
public:
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {

        vector<int> source(2, 0);
        int playerDistance = manhattanDistance(source, target);

        for (vector<int> ghost: ghosts) {
            if (manhattanDistance(ghost, target) <= playerDistance) {
                return false;
            }
        }

        return true;


    }

private:
    int manhattanDistance(vector<int>& pointOne, vector<int>& pointTwo) {
        return abs(pointOne[0] - pointTwo[0]) + abs(pointOne[1] - pointTwo[1]);
    }
};