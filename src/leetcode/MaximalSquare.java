/**
 * Copyright (C), 2018-2019
 * FileName: MaximalSquare
 * Author:   Tyson
 * Date:     2019/5/7/0007 10:19
 * Description: 最大正方形
 */
package leetcode;

/**
 * @author Tyson
 * @ClassName: MaximalSquare
 * @create 2019/5/7/0007 10:19
 */
class MaximalSquare {
    //maxLen[i][j]是以第i-1行j-1列为右下角所能构成的最大正方形的边长
    //递推式：maxLen[i][j] = 1 + min(maxLen[i - 1][j], maxLen[i - 1][j -1], maxLen[i][j - 1]
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] maxLen = new int[row][column];
        int max = 0;
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == '1') {
                maxLen[i][0] = 1;
                max = 1;
            }
        }

        for(int j = 0; j < column; j++) {
            if(matrix[0][j] == '1') {
                maxLen[0][j] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '1') {
                    maxLen[i][j] = 1 + Math.min(maxLen[i - 1][j],
                            Math.min(maxLen[i][j - 1], maxLen[i - 1][j - 1]));
                }
                max = Math.max(maxLen[i][j], max);
            }
        }

        return max * max;
    }
}