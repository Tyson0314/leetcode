package leetcode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] curRow = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            curRow[i] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                curRow[j] += curRow[j-1];
            }
        }
        return curRow[n-1];
    }
}