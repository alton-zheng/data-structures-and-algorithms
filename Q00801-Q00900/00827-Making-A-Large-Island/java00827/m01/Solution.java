package java00827.m01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-18 08:52
 * @Update Date Time: 2022-09-18 08:52
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {

    // 压缩状态，记录了 4 中二维上下左右 4 种组合
    static int[] addressChange = {0, -1, 0, 1, 0};

    public int largestIsland(int[][] grid) {

        // 根据题意，定义 n 为二维数组的长度， 最大面积 res
        int n = grid.length, res = 0;

        // 由于 row, col 长度一致， 定义变化后的 tag
        int[][] tag = new int[n][n];

        // 存储每个点 island 面积
        Map<Integer, Integer> area = new HashMap<>();

        // 第一次遍历二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 如果原二维数组当前 grid[i][j] 为 1， 且 tag[i][j] = 0（没有记录过）
                // 在 hashMap 中记录当前位置的所能达到的最大面积
                if (grid[i][j] == 1 && tag[i][j] == 0) {

                    // 当前位置标记 t -> i * n + j + 1 表示
                    int t = i * n + j + 1;

                    // 在 area 记录当前位置岛面积
                    area.put(t, dfs(grid, i, j, tag, t));

                    // 求出当前的最大面积
                    res = Math.max(res, area.get(t));
                }
            }
        }

        // 到此为止， res 代表着还未将一个位置 0 -> 1 时的最大 res
        // 第二次遍历 grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // grid[i][j] 为 0 时，才会有变更为 1 的机会， 否则不需要处理当前位置
                if (grid[i][j] == 0) {

                    // 合并后的面积 z, 默认为 0 -> 1 当前位置的面积 1
                    int z = 1;
                    
                    // 记录与 grid[i][j] 相连的岛屿
                    Set<Integer> connected = new HashSet<>();
                    
                    // 从 4 个方向开始判断
                    for (int k = 0; k < 4; k++) {
                        // 4 个方向变化组合
                        int x = i + addressChange[k], y = j + addressChange[k + 1];
                        
                        // 1. x, y 位置失效，超出范围
                        // 2. tag[x][y] = 0 意味着和 grid[i][j] 1 是连不上的
                        // 3. connected 包含了 tag[x][y] 说明第二次遍历中已经判断过它了，不要重复判断
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
                            
                            // 满足3种 条件之一， 不需要判断连通性了，直接判断下一方向
                            continue;
                        } 
                        
                        // 如果非上面 3 种情况，说明当前方向可以和首次遍历的岛屿区域进行联通
                        // z 面积加上首次遍历的 x, y 位置面积相加
                        z += area.get(tag[x][y]);
                        
                        // 记录 connected, 说明 x, y 被记录了，后面不再重复记录
                        // 因为 tag[x][y] 面积是固定的，重复记录没有意义
                        connected.add(tag[x][y]);
                    }
                    
                    // 记录最大面积
                    res = Math.max(res, z);
                }
            }
        }
        
        // 返回最大面积
        return res;
    }

    /**
     * 深度优先遍历，获取当前位置 island 面积
     * @return
     */
    public int dfs(int[][] grid, int x, int y, int[][] tag, int t) {

        // 长度 n, 每个格子代表面积 1
        int n = grid.length, res = 1;

        // 标记当前位，标记为 t, 说明当前为被记录过了，下次不会重复记录
        tag[x][y] = t;

        // 从上下左右开始递归遍历，判断是否连岛
        for (int i = 0; i < 4; i++) {

            // 根据 4 种组合， 变化当前位置的 4 种位置变化
            int x1 = x + addressChange[i], y1 = y + addressChange[i + 1];

            // 1. x1, y1 位置有效
            // 2. grid[x1][y1] -> 1
            // 3. tag[x1][y1] = 0 (没被记录过)
            if (valid(n, x1, y1) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {

                // 满足上面 3 个条件，记录递归判断
                // 累加下一位置面积
                res += dfs(grid, x1, y1, tag, t);
            }
        }

        // 返回 res
        return res;
    }


    // 判断 x, y 是否还在位置数组范围
    public boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}


