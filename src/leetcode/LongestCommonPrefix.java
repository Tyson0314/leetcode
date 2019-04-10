/**
 * Copyright (C), 2018-2018
 * FileName: LongestCommonPrefix
 * Author:   Tyson
 * Date:     2018/7/27/0027 3:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/7/27/0027
 * @since 1.0.0
 */
public class LongestCommonPrefix {
    public String findLongestCommonPrefix(String[] strs) {
        for(int i = 0; i < strs.length; i++) {
            if(strs[i] == null || "".equals(strs[i]))
                return "";
        }

        int length = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < length)
                length = strs[i].length();
        }

        for(int i = 1; i < strs.length; i++) {
            for(int j = 0; j < length; j++) {
                if(strs[i].charAt(j) != strs[0].charAt(j) && j != 0) {
                    length = j;
                } else if(strs[i].charAt(j) != strs[0].charAt(j) && j == 0) {
                    return "";
                }
            }
        }

        for(int i = 0; i < strs.length; i++) {
            if(strs[i].charAt(length) != strs[0].charAt(length))
                length = length - 1;
        }
        return strs[0].substring(0, length + 1);
    }

    public static void main(String[] args) {
        String[] strArr = {};
        String s = new LongestCommonPrefix().findLongestCommonPrefix(strArr);
        System.out.println(s);
    }
}