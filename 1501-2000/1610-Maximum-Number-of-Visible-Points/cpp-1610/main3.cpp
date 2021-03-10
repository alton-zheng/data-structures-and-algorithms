/// Source : https://leetcode.com/problems/maximum-number-of-visible-points/
/// Author : liuyubobobo
/// Time   : 2020-10-04

#include <iostream>
#include <vector>

using namespace std;


/// atan2 to sort and sliding window
/// deal with >= 2 * pi with cat another array
/// Time Complexity: O(nlogn)
/// Space Complexity: O(n)
class Solution {

private:
    double eps = 1e-6;

public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {

        int n = points.size();

        vector<double> v;
        int base = 0;
        for(const vector<int>& p: points)
            if(p[0] == location[0] && p[1] == location[1])
                base ++;
            else{
                int x = p[0] - location[0], y = p[1] - location[1];
                double ang = atan2(y, x);
                if(ang < 0) ang += 2 * M_PI;
                v.push_back(ang);
            }

        sort(v.begin(), v.end());
//        for(double e: v) cout << e << " "; cout << endl;
        for(int i = 0; i < n; i ++)
            v.push_back(v[i] + 2 * M_PI);

        double a = angle * M_PI / (double)180.0 + eps;
        int res = 0, l = 0, r = -1;
        while(l < n){
            if(r + 1 < v.size() && v[r + 1] - v[l] <= a){
                r ++;
                res = max(res, base + r - l + 1);
            }
            else l ++;
        }
        return res;
    }
};


int main() {

    vector<vector<int>> points1 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {1, 2}, {2, 1}};
    vector<int> loc1 = {1, 1};
    cout << Solution().visiblePoints(points1, 0, loc1) << endl;
    // 4

    vector<vector<int>> points2 = {{1000000000,999999999},{999999999,1000000000}};
    vector<int> loc2 = {0,0};
    cout << Solution().visiblePoints(points2, 90, loc2) << endl;
    // 2

    vector<vector<int>> points3 = {{13779926,599856510},{195766825,597976710},{119515491,575316056},{744777345,796161766},{187192636,870346582},{413112378,430889309},{436399518,387904921},{296153131,221188617},{536914240,985130562},{226391292,83241861}};
    vector<int> loc3 = {451961560,358354259};
    cout << Solution().visiblePoints(points3, 64, loc3) << endl;
    // 6

    return 0;
}
