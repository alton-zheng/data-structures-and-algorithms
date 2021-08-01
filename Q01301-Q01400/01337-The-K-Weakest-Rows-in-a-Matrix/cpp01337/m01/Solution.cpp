// Runtime: 12 ms, faster than 67.51% of C++ online submissions for The K Weakest Rows in a Matrix.
// Memory Usage: 10.6 MB, less than 45.19% of C++ online submissions for The K Weakest Rows in a Matrix.
class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {

        vector<int> res(k);

        auto compare = [](const pair<int, int>& p1, const pair<int, int>& p2) {
            return p1.first != p2.first ? p2.first > p1.first : p2.second > p1.second;
        };

        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(compare)> q(compare);

        for (int i = 0; i < mat.size(); i++) {
            q.push(pair<int, int>(getOnes(mat[i]), i));
            if (q.size() > k) {
                q.pop();
            }
        }

        while (k > 0) {
            res[--k] = q.top().second;
            q.pop();
        }

        return res;
    }

private:
    int getOnes(vector<int>& arr) {

        int left = 0, right = arr.size();

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
};