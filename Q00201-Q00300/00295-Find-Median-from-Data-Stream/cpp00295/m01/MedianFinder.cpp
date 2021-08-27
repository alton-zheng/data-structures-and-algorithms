/**
Runtime: 659 ms, faster than 5.01% of C++ online submissions for Find Median from Data Stream.
Memory Usage: 117 MB, less than 23.34% of C++ online submissions for Find Median from Data Stream.
*/
class MedianFinder {
private:
    priority_queue<int, vector<int>, less<int>> queMin;
    priority_queue<int, vector<int>, greater<int>> queMax;

public:
    MedianFinder() {}

    void addNum(int num) {
        if (queMin.empty() || num <= queMin.top()) {
            queMin.push(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.push(queMin.top());
                queMin.pop();
            }
        } else {
            queMax.push(num);
            if (queMax.size() > queMin.size()) {
                queMin.push(queMax.top());
                queMax.pop();
            }
        }
    }

    double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.top();
        }

        return (queMin.top() + queMax.top()) / 2.0;
    }
};