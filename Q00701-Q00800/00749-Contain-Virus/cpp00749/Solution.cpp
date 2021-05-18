class cluster{
public:
    set<pair<int, int>> c; //已经被感染
    set<pair<int, int>> uc; //即将被感染
    int cnt = 0;
    friend bool operator < (const cluster& a, const cluster& b){
        return a.uc.size() < b.uc.size();
    }
};

class Solution {
public:
    int containVirus(vector<vector<int>>& grid) {
        m = grid.size(), n = grid[0].size();
        int cnt = 0;
        while(1){
            visited = vector<vector<bool>>(m, vector<bool>(n, 0));
            priority_queue<cluster> pq;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && grid[i][j] == 1){
                        cluster t;
                        dfs(grid, i, j, t);
                        pq.push(t);
                    }
                }
            }
            if(pq.size() == 0) break;
            cluster t = pq.top();
            pq.pop();
            for(auto s : t.c) grid[s.first][s.second] = -1;
            cnt += t.cnt;
            while(!pq.empty()){
                cluster t = pq.top();
                pq.pop();
                for(auto s : t.uc) grid[s.first][s.second] = 1;
            }
        }
        return cnt;
    }
private:
    int m, n;
    vector<vector<bool>> visited;
    vector<vector<int>> dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    bool valid(int x, int y){
        return !(x<0 || y<0 || x>=m || y>=n);
    }

    void dfs(vector<vector<int>>& grid, int x, int y, cluster &cc){
        if(grid[x][y] == 0){
            cc.cnt++;
            cc.uc.insert({x, y});
            return;
        }
        cc.c.insert({x, y});
        visited[x][y] = 1; //不放在下方循环内是为了可以再次访问会被感染的区域，避免漏掉防火墙
        for(int i=0; i<4; i++){
            int xx = x+dir[i][0], yy = y+dir[i][1];
            if(valid(xx, yy) && !visited[xx][yy] && grid[xx][yy] != -1){
                dfs(grid, xx, yy, cc);
            }
        }
    }
};