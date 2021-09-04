class Solution {
public:
    vector<int> smallestK(vector<int>& arr, int k) {

        int len = arr.size();

        if (k == 0 || len == 0) {

            return {};
        }

        // 自己用快排实现，比自带的排序性能优越
        return quickOrder(arr, 0, len - 1, k - 1);

    }

private:
    vector<int> quickOrder(vector<int>& arr, int startIndex, int endIndex, int leastNumberArrayMaxIndex) {

        int quickIndex = quickPartition(arr, startIndex, endIndex);

        if (quickIndex == leastNumberArrayMaxIndex) {
            vector<int> result(leastNumberArrayMaxIndex + 1);

            for (int i = 0; i <= leastNumberArrayMaxIndex; i++) {
                result[i] = arr[i];
            }

            return result;
        }

        return quickIndex > leastNumberArrayMaxIndex
                ? quickOrder(arr, startIndex, quickIndex - 1, leastNumberArrayMaxIndex)
                : quickOrder(arr, quickIndex + 1, endIndex, leastNumberArrayMaxIndex);

    }

    int quickPartition(vector<int>& arr, int startIndex, int endIndex) {

        int compareValue = arr[startIndex];
        int i = startIndex, j = endIndex + 1;

        while (true) {
            while (++i <= endIndex && arr[i] < compareValue);
            while (--j >= startIndex && arr[j] > compareValue);

            if (i >= j) {
                break;
            }

            swap(arr[i], arr[j]);

        }

        arr[startIndex] = arr[j];
        arr[j] = compareValue;

        return j;
    }
};