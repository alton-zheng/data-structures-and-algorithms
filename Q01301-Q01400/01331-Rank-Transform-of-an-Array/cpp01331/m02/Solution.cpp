// Runtime: 88 ms, faster than 79.18% of C++ online submissions for Rank Transform of an Array.
// Memory Usage: 39.4 MB, less than 57.92% of C++ online submissions for Rank Transform of an Array.
class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {

        if (arr.size() == 0) {
            return {};
        }

         vector<int> temp(arr.size());

        for (int i = 0; i < arr.size(); i++) {
            temp[i] = arr[i];
        }

         sort(temp.begin(), temp.end());

         unordered_map<int, int> help;

         help[temp[0]] = 1;

         for (int i = 1; i < temp.size(); i++) {
            if (temp[i] == temp[i - 1]) {
                help[temp[i]] = help[temp[i - 1]];
            } else {
                help[temp[i]] = help[temp[i - 1]] + 1;
            }
         }

         for (int i = 0; i < arr.size();  i++) {
            arr[i] = help[arr[i]];
         }

         return arr;

    }
};