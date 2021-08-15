class Solution {
private:
    int m, n;
    int getOBS(int help[][52][52], int steps, int x, int y){

        if(x > n || x <= 0 || y > m || y <= 0) {
            return 1;
        }

        if(!steps) {
            return 0;
        }

        if(help[x - 1 ][y][steps - 1]== -1) {
            help[x - 1 ][y][steps - 1 ]=getOBS(help, steps - 1 , x - 1 , y);
        }

        if(help[x + 1][y][steps - 1]== -1) {
            help[x + 1][y][steps - 1 ]=getOBS(help, steps - 1 , x + 1, y);
        }

        if(help[x][y - 1 ][steps - 1]== -1) {
            help[x][y - 1 ][steps - 1 ]=getOBS(help, steps - 1 , x, y - 1 );
        }
        if(help[x][y + 1][steps - 1]== -1) {
            help[x][y + 1][steps - 1 ]=getOBS(help, steps - 1 , x, y + 1);
        }
        return ((long)help[x - 1 ][y][steps - 1 ]+help[x + 1][y][steps - 1 ]+help[x][y - 1 ][steps - 1 ]+help[x][y + 1][steps - 1 ])%1000000007;
    }

public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this -> m = m;
        this -> n = n;
        int help[52][52][52];
        memset(help,  -1 , sizeof(help));
        return getOBS(help, maxMove, startColumn + 1, startRow + 1);
    }

};