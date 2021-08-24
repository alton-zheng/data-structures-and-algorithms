package java00787.m02;

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int INF = 101 * 10000 + 1;
        
        int[] help = new int[n];

        Arrays.fill(help, INF);

        help[src] = 0;
        int res = INF;
        
        for (int t = 1; t < k + 2; t++) {
            
            int[] h = new int[n];
            Arrays.fill(h, INF);
            
            for (int[] flight: flights) {
                int s = flight[0], d = flight[1], c = flight[2];
                h[d] = Math.min(h[d], help[s] + c);
            }
            
            help = h;
            
            res = Math.min(res, help[dst]);
        }

        
        return res == INF ? -1 : res;
    }
}