// Runtime: 160 ms, faster than 23.75% of C++ online submissions for Rank Transform of an Array.
// Memory Usage: 52.6 MB, less than 6.58% of C++ online submissions for Rank Transform of an Array.
class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {

         // 存储每个元素所在索引位置，并按元素从小到大排序(map 自带排序功能)
         map<int, vector<int>> help;

         // 将元素放入到 help 容器中
         for (int i = 0; i < arr.size(); i++) {
            help[arr[i]].push_back(i);
         }

         vector<int> res(arr.size());

         // 遍历元素，将 rank 值更新到结果集中（元素从小到大，排列 rank）
         int idx = 1;
         for (auto item: help) {
            for (int i: item.second) {
                res[i] = idx;
            }

            idx++;
         }

         return res;

    }
};