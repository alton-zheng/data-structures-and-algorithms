class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        int jewelsCount = 0;
        unordered_set<char> jewelsSet;
        int jewelsLength = jewels.length(), stonesLength = stones.length();
        for (int i = 0; i < jewelsLength; i++) {
            char jewel = jewels[i];
            jewelsSet.insert(jewel);
        }
        for (int i = 0; i < stonesLength; i++) {
            char stone = stones[i];
            if (jewelsSet.count(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
};

class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        int jewelsCount = 0;
        unordered_set<char> jewelsSet;

        for (int i = 0; i < jewels.size(); i++) {
            jewelsSet.insert(jewels[i]);
        }

        for (int i = 0; i < stones.size(); i++) {
            if (stones.count(stones[i])) {
            jewelsCount++;
            }
        }

        return jewelsCount;

    }
};