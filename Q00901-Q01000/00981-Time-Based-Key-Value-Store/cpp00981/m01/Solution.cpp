// Runtime: 264 ms, faster than 94.87% of C++ online submissions for Time Based Key-Value Store.
// Memory Usage: 128 MB, less than 75.50% of C++ online submissions for Time Based Key-Value Store.
class TimeMap {
    unordered_map<string, vector<pair<int, string>>> m;

public:
    TimeMap() {}

    void set(string key, string value, int timestamp) {
        m[key].emplace_back(timestamp, value);
    }

    string get(string key, int timestamp) {
        auto& pairs = m[key];
        pair<int,string> search = {timestamp, string({127})};
        auto i = upper_bound(pairs.begin(), pairs.end(), search);
        if (i != pairs.begin()) {
            return (i - 1) -> second;
        }

        return "";
    }
};