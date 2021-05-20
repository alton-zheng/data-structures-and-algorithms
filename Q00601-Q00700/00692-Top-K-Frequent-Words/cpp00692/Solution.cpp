/*
方法： map + 优先队列
相比 java 实现来说， 它的效率较低。两者底层实现不同
*/
class Solution {

public:
    vector<string> topKFrequent(vector<string>& words, int k) {

        // 定义 map
        unordered_map<string, int> wordsCount;

        // 统计 words 中每个单词出现的次数
        for (string word: words) {
            wordsCount[word]++;
        }

        // 自定义比较器
        auto compare = [](const pair<string, int>& wc1, const pair<string, int>& wc2) {
            return wc1.second == wc2.second ? wc1.first > wc2.first : wc1.second < wc2.second;
        };

        // 自定义优先队列
        priority_queue<pair<string, int>, vector<pair<string, int>>, decltype(compare) > que(compare);

        // 添加元素到优先队列
        for (auto& wc: wordsCount) {
            que.emplace(wc);
        }

        vector<string> res(k);

        // 将优先队列前 k 个元素 first 值放入到 res 中
        for (int i = 0; i < k; i++){
            res[i] = que.top().first;
            que.pop();
        }

        return res;

    }


};