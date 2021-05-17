class Solution {

public:
    vector<string> getFolderNames(vector<string>& names) {

        unordered_map<string, int> sNumbers;

        for (int i = 0; i < names.size(); i++) {

            string s = names[i];

            if (sNumbers.count(s)) {

                while (sNumbers.count(names[i] = s + "(" + to_string(sNumbers[s]) + ")")) {
                    sNumbers[s] = sNumbers[s] + 1;
                }
            } else {
                sNumbers[s] = 1;
            }

            sNumbers[names[i]] = sNumbers[names[i]] >= 1 ? sNumbers[names[i]] : 1;
        }

        return names;
    }
};