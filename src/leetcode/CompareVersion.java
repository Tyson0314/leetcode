/**
 * Copyright (C), 2018-2019
 * FileName: CompareVersion
 * Author:   Tyson
 * Date:     2019/4/17/0017 12:35
 * Description: 比较版本
 */
package leetcode;

/**
 * @author Tyson
 * @ClassName: CompareVersion
 * @create 2019/4/17/0017 12:35
 */
public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        char[] arr1 = version1.toCharArray();
        char[] arr2 = version2.toCharArray();

        for(int i = 0, j = 0; i < arr1.length || j < arr2.length; i++, j++) {
            int v1 = 0, v2 = 0;
            for(; i < arr1.length && arr1[i] != '.'; i++) {
                v1 = 10 * v1 + arr1[i] - '0';
            }
            for(; j < arr2.length && arr2[j] != '.'; j++) {
                v2 = 10 * v2 + arr2[j] - '0';
            }
            if(v1 > v2) {
                return 1;
            }
            if(v2 > v1) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "0.2"));
    }
}