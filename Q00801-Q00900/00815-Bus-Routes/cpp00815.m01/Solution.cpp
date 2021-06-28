class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {

        // 起始点和终点一样，说明不需要坐公交车， 直接返回 0 即可。
        if (source == target) {
            return 0;
        }


        int l = routes.size();

        // 维护哪些公交路线两两是通的
        vector<vector<int>> edge(l, vector<int>(l));

        // 维护站点所在的所有公交路线
        unordered_map<int, vector<int>> rec;

        // 下边代码增加和更新上述 edege , rec 的具体内容
        for (int i = 0; i < l; i++) {
            for (int site : routes[i]) {
                for (int j : rec[site]) {
                    edge[i][j] = edge[j][i] = true;
                }
                rec[site].push_back(i);
            }
        }

        if (!rec.count(source) || !rec.count(target)) {
            return -1;
        }

        vector<int> dis(l, -1);


        queue<int> que;

        // 首先看出发点在哪些公交路线上有，将他们添加到 bfs 队列 que 中，并将它们所乘坐的公交车数量置于 1
        for (int bus : rec[source]) {
            dis[bus] = 1;
            que.push(bus);
        }

        //
        while (!que.empty()) {
            int x = que.front();
            que.pop();

            for (int y = 0; y < l; y++) {

                // 如果 2 公交路线有公共公交站，且 y 不属于出发点所在的路线
                // （因为这种场景可以排除掉， 因为如果 y 属于出发点，假设终点在 y 上或者在 y 的公共公交路线上，它能更快的到终点）
                if (edge[x][y] && dis[y] == -1) {

                    // 那么从出发点到 y 所乘坐的公交路线数量在 x 基础上加 1
                    dis[y] = dis[x] + 1;

                    // 将 y 公交路线放入到 queue 中
                    que.push(y);

                }
            }
        }

        int ret = INT_MAX;

        // 找到乘坐公交最小的数量
        for (int bus : rec[target]) {
            if (dis[bus] != -1) {
                ret = min(ret, dis[bus]);
            }
        }
        // 如果 source 不能到 target ,返回 -1， 能到返回 ret
        return ret == INT_MAX ? -1 : ret;
    }
};