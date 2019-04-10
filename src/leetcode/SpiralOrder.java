/**
 * Copyright (C), 2018-2018
 * FileName: SpiralOrder
 * Author:   Tyson
 * Date:     2018/12/4/0004 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyson
 * @create 2018/12/4/0004 9:30
 * @since 1.0.0
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while(rowStart * 2 < matrix.length && columnStart * 2 < matrix[0].length) {
            for(int i = columnStart; i <= columnEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            for(int j = rowStart + 1; j <= rowEnd; j++) {
                result.add(matrix[j][columnEnd]);
            }
            for(int m = columnEnd - 1; m >= columnStart && rowEnd > rowStart; m--) {
                result.add(matrix[rowEnd][m]);
            }
            for(int n = rowEnd - 1; n > rowStart; n--) {
                result.add(matrix[n][columnStart]);
            }

            rowStart++;
            rowEnd--;
            columnStart++;
            columnEnd--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}};

        SpiralOrder so = new SpiralOrder();

        List<Integer> result = so.spiralOrder(matrix);

        result.forEach(n -> System.out.print(n + " "));
    }
}