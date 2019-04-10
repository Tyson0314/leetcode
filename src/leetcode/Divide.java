/**
 * Copyright (C), 2018-2018
 * FileName: Divide
 * Author:   Tyson
 * Date:     2018/8/11/0011 0:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/8/11/0011
 * @since 1.0.0
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        long startTime = System.currentTimeMillis();
        if(dividend == 0) {
            return 0;
        }
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        boolean isDiffSign = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);

        int dvd = Math.abs(dividend);
        int dvs = Math.abs(divisor);
        int result = 0;

        while(dvd >= dvs) {
            int tmp = dvs;
            int multiply = 1;

            while(dvd >= (tmp << 1)) {
                tmp = tmp << 1;
                multiply = multiply << 1;
            }

            dvd -= tmp;
            result += multiply;
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        return isDiffSign ? (-1)*result : result;
    }

    public static void main(String[] args) {
        String s = null;
        s.charAt(0);
        System.out.println(new Divide().divide(2147483647, 1));
    }
}