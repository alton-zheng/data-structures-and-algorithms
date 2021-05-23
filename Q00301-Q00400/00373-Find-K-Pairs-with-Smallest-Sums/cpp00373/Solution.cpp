/**
 * 优先队列
 * Time Complexity: O(m*n*longm*n)
 * Space Complexity: O(k)
 */
class Solution {
public:
	vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {

        // 由于题目保证数组是从小到大排序，且元素个数从 1 开始，不需要判断个数为空的情况

        // 获取数组长度
        int nums1Len = nums1.size(), nums2Len = nums2.size();

        // 自定义比较器
        auto compare = [](const pair<int, pair<int, int>>& pair1, const pair<int, pair<int, int>>& pair2) {
            return pair1.first + pair1.second.first > pair2.first + pair2.second.first;
        };

        // 自定义优先队列
        priority_queue<pair<int, pair<int,int>>, vector<pair<int, pair<int, int>>>, decltype(compare)> pqueue(compare);

        // 比较两数组的长度
        int flag = 0;
        if (nums1Len > nums2Len) {
            flag = 1;
            swap(nums1, nums2);
            swap(nums1Len, nums2Len);
        }

        // 初始化 pqueue, 写入队列元素为短长度数组长度
        for (int i = 0; i < nums1Len; i++) {
            pqueue.push(pair<int,pair<int,int>>(nums1[i], pair<int,int>(nums2[0], 0)));
        }

        // 定义结果
        vector<vector<int>> resList;
        // 获取 k 个最小 tuple 组
        for (int i = 0; i < k && !pqueue.empty(); i++) {
            pair<int, pair<int, int>> item = pqueue.top();
            pqueue.pop();

            if (flag == 0) {
                resList.push_back({item.first, item.second.first});
            } else {
                resList.push_back({item.second.first, item.first});
            }

            if (item.second.second < nums2Len - 1) {
                item.second.second++;
                item.second.first = nums2[item.second.second];
                pqueue.push(item);
            }
        }

        return resList;
	}
};