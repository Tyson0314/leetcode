/**
 * Copyright (C), 2018-2018
 * FileName: ReverseInt
 * Author:   Tyson
 * Date:     2018/7/23/0023 23:20
 * Description: reverse integer
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/7/23/0023
 * @since 1.0.0
 */
public class ReverseInt {
    public int reverse(int x) {
        if(x == 0)
            return 0;

        boolean isNegativeNum = false;
        if (x < 0) {
            x = -x;
            isNegativeNum = true;
        }

        String s = String.valueOf(x);
        if(s.length() >= 10) {

            //是否可被10正整除
            while (x % 10 == 0)
                x %= 10;

            int tmp = x;
            //divided by 10, find the bits of num
            int numsOfDigits = 0;
            while (tmp > 0) {
                numsOfDigits++;
                tmp /= 10;
            }

            int reverseNum = 0;
            for (int i = 0; i < numsOfDigits; i++) {
                tmp = (int) (x / Math.pow(10, numsOfDigits - 1 - i)) % 10;
                reverseNum += (int) (tmp * Math.pow(10, i));
                //System.out.println(reverseNum);
            }

            if (reverseNum < 0)
                return 0;

            if (isNegativeNum == true)
                return -reverseNum;

            return reverseNum;
        } else {
            StringBuffer sb = new StringBuffer("");
                for(int i = s.length() - 1; i >= 0; i--) {
                    sb.append(s.charAt(i));
                }
                if(isNegativeNum == false)
                    return Integer.valueOf(sb.toString());

                return (-1)*(int)Integer.valueOf(sb.toString());
            }

        }


    public static void main(String[] args) {
        System.out.println(String.valueOf(-123));
        int num = new ReverseInt().reverse(-123);
        System.out.println(num);
    }
}