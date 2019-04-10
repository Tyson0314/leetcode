/**
 * Copyright (C), 2018-2018
 * FileName: NumEncoding
 * Author:   Tyson
 * Date:     2018/12/25/0025 10:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/12/25/0025 10:08
 * @since 1.0.0
 */
public class NumDecoding {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        if(s.length() == 1) {
            if(arr[0] == '0') {
                return 0;
            }
            return 1;
        }

        int[] flag = new int[s.length()];
        flag[0] = 1;
        if(arr[0] <= '2' && arr[1] <= '6' && arr[1] != '0') {
            flag[1] = 2;
        } else if((arr[0] == '0' && arr[1] == '0') || (arr[0] == '0' && arr[1] == '1')) {
            flag[0] = 0;
            flag[1] = 0;
        } else {
            flag[1] = 1;
        }

        for(int i = 2; i < arr.length; i++) {
            if(arr[i - 1] == '2') {
                if(arr[i] <= '6' && arr[i] != '0') {
                    flag[i] = flag[i - 1] + flag[i - 2];
                } else {
                    flag[i] = flag[i - 1];
                }
            } else if(arr[i - 1] == '1') {
                if(arr[i] != '0') {
                    flag[i] = flag[i - 1] + flag[i - 2];
                } else {
                    flag[i] = flag[i - 1];
                }
            } else {
                flag[i] = flag[i - 1];
            }
        }

        return flag[flag.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("01"));
    }
}