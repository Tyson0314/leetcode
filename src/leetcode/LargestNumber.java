/**
 * Copyright (C), 2018-2019
 * FileName: LargestNumber
 * Author:   Tyson
 * Date:     2019/4/25/0025 9:44
 * Description: 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。输入: [3,30,34,5,9] 输出: 9534330
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tyson
 * @ClassName: LargestNumber
 * @create 2019/4/25/0025 9:44
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "0";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String tmp1 = s1 + s2;
                String tmp2 = s2 + s1;

                return tmp2.compareTo(tmp1);
            }
        });

        if ("0".equals(strs[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}
