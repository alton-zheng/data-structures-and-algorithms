class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
       unordered_set<int> help;

       for (auto& candy: candyType) {
            help.insert(candy);
       }

       return min(candyType.size() / 2, help.size());
    }
};