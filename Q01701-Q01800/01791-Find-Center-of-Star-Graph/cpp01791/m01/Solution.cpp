// Runtime: 180 ms, faster than 69.92% of C++ online submissions for Find Center of Star Graph.
// Memory Usage: 67.4 MB, less than 54.34% of C++ online submissions for Find Center of Star Graph.
class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        // 要么首条 edge 第一个节点(edges[0][0])是交点，
        // 要么首边 edge 第二个节点(edge[0][1])是交点
        return (edges[0][0]==edges[1][0] || edges[0][0]==edges[1][1])?edges[0][0] : edges[0][1];
    }
};