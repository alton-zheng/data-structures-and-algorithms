// Runtime: 8 ms, faster than 56.96% of C++ online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
// Memory Usage: 11.2 MB, less than 24.85% of C++ online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
class Solution {
public:
    int temp;
    bool flag;

    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {

        int len = mat.size();

        // 旋转 4 次,每旋转一次，比对一次
        for (int k = 0; k < 4; k++) {
            // 旋转操作
            for (int i = 0; i < len / 2; i++) {
                for (int j = 0; j < (len + 1) / 2; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[len-1-j][i];
                    mat[len-1-j][i] = mat[len-1-i][len-1-j];
                    mat[len-1-i][len-1-j] = mat[j][len-1-i];
                    mat[j][len-1-i] = temp;
                }
            }

            if (mat == target) {
                return true;
            }
        }
        return false;
    }
};