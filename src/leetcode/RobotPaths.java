/**
 * Copyright (C), 2018-2019
 * FileName: RobotPaths
 * Author:   Tyson
 * Date:     2019/1/18/0018 21:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2019/1/18/0018 21:42
 * @since 1.0.0
 */

class RobotPaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 动态规划问题，以 62 号问题为基础
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // memo 用于存储到达该位置的路径总数
        int[][] memo = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            memo[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            memo[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[n - 1][m - 1];
    }

    public static void main(String[] args) {
        RobotPaths rp = new RobotPaths();
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int m = rp.uniquePathsWithObstacles(arr);
    }
}