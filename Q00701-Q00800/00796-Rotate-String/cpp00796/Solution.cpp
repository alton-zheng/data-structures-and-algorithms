// KMP
// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Rotate String.
// Memory Usage: 6.3 MB, less than 32.05% of C++ online submissions for Rotate String.
class Solution {
public:
    void getNext(string& p, vector<int>& next) {
        int pLen = p.size();
        next.resize(pLen, -1);
        int k = -1, j = 0;
        while (j < pLen - 1) {
            if (k == -1 || p[k] == p[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
    bool rotateString(string A, string B) {
        if (A.size() != B.size()) return false;
        A += A;
        int aLen = A.size();
        int bLen = B.size();
        vector<int> next;
        getNext(B, next);
        int i = 0, j = 0;
        while (i < aLen && j < bLen) {
            if (j == -1 || A[i] == B[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == bLen ? true : false;
    }
};