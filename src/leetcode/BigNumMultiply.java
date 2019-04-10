/**
 * Copyright (C), 2018-2018
 * FileName: BigNumMultiply
 * Author:   Tyson
 * Date:     2018/9/10/0010
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/9/10/0010
 * @since 1.0.0
 */
class BigNumMultiply {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }

        int[] arr = new int[num1.length() + num2.length()];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        for(int i = chars1.length - 1; i >= 0; i--) {
            for(int j = chars2.length - 1; j >= 0; j--) {
                arr[i + j + 1] += (chars1[i] - '0') * (chars2[j] - '0');
            }
        }

        int overflow = 0;
        for(int k = arr.length - 1; k >= 0; k--) {
            arr[k] += overflow;
            overflow = arr[k] / 10;
            arr[k] %= 10;
        }

        int n = 0;
        for(; n < arr.length - 1; n++) {
            if(arr[n] != 0) {
                break;
            }
        }
        StringBuffer sb = new StringBuffer("");
        for(int m = n; m < arr.length; m++) {
            sb.append(arr[m]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BigNumMultiply().multiply("123", "456"));
    }
}