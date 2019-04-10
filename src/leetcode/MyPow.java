/**
 * Copyright (C), 2018-2018
 * FileName: MyPow
 * Author:   Tyson
 * Date:     2018/12/10/0010 20:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Tyson
 * @create 2018/12/10/0010 20:24
 * @since 1.0.0
 */
class MyPow {
    public static double myPow (double x, int n) {
        if(x == 0) {
            return 0;
        }

        int absN = Math.abs(n);

        if(n > 0) {
            return myPowHelper(x, absN);
        } else {
            return 1 / myPowHelper(x, absN);
        }
    }

    public static double myPowHelper(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        int half = n / 2;
        double result = myPowHelper(x, half);

        if(n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }

    public static void main(String[] args) {
        double result = MyPow.myPow(2.0, 10);
        System.out.println(result);

        double x = 1.0;
        System.out.println(x == 1);
        HashMap<String, String> map = new HashMap<>();
        char[] arr = "helo".toCharArray();
        Arrays.sort(arr);
        System.out.println(new String(arr));

        int[][] arr1 = {{1, 2},{3, 4}};
        int[][] newArr = new int[2][2];
        for(int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i].clone();
        }
        for(int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }
}