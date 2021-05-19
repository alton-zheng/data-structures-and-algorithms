class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {

       int rLen = matrix.size(), cLen = matrix[0].size();

        vector<int> res = vector<int>(rLen * cLen);
        int resIndex = 0;
        vector<vector<int>> help = vector<vector<int>>(rLen + 1, vector<int>(cLen + 1));

        for (int i = 1; i <= rLen; i++) {
            for (int j = 1; j <= cLen; j++) {
                help[i][j] = help[i - 1][j] ^ help[i - 1][j - 1] ^ help[i][j - 1] ^ matrix[i - 1][j - 1];
                res[resIndex++] = help[i][j];
            }
        }

        return getKthLargestValue(res, 0, rLen * cLen - 1, k - 1);

    }

private:
    int getKthLargestValue(vector<int>& res, int startIndex, int endIndex, int targetIndex) {

        int index = getIndexFromQuickOrder(res, startIndex, endIndex);

        if (index == targetIndex) {
            return res[targetIndex];
        }

        return index > targetIndex
                ? getKthLargestValue(res, startIndex, index - 1, targetIndex)
                : getKthLargestValue(res, index + 1, endIndex, targetIndex);

    }

    int getIndexFromQuickOrder(vector<int>& res, int startIndex, int endIndex) {

        int initValue = res[startIndex];
        int start = startIndex, end = endIndex + 1;
        while (true) {

            while (++start <= endIndex && res[start] > initValue);
            while (--end >= startIndex && res[end] < initValue);

            if (end <= start) {
                break;
            }

            int swap = res[start];
            res[start] = res[end];
            res[end] = swap;

        }

        res[startIndex] = res[end];
        res[end] = initValue;

        return end;

    }
};