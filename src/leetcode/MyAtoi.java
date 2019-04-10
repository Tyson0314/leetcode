/**
 * Copyright (C), 2018-2018
 * FileName: MyAtoA
 * Author:   Tyson
 * Date:     2018/8/4/0004 17:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/8/4/0004
 * @since 1.0.0
 */
public class MyAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;

        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        if (index < str.length() && (str.charAt(index) - '0' > 9 || str.charAt(index) - '0' < 0) &&
                str.charAt(index) != '+' && str.charAt(index) != '-') {
            return 0;
        }

        int sign = 1;
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = (str.charAt(index) == '+') ? 1 : -1;
            index++;
        }
        int res = 0;
        for (; index < str.length(); index++) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (str.charAt(index) - '0' > 7))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if (str.charAt(index) - '0' > 9 || str.charAt(index) - '0' < 0) {
                return sign * res;
            }
            res = res * 10 + (str.charAt(index) - '0');
        }

        return sign * res;
    }
    
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi(" -1010023630o4"));
    }
}