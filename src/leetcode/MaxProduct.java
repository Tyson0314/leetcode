/**
 * Copyright (C), 2018-2019
 * FileName: MaxProduct
 * Author:   Tyson
 * Date:     2019/4/14/0014 10:02
 * Description: 乘积最大子序列
 */
package leetcode;

/**
 * @author Tyson
 * @ClassName: MaxProduct
 * @create 2019/4/14/0014 10:02
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int maxCur = Integer.MIN_VALUE;
        //保存num[i - 1]最大和最小值
        int max = 1, min = 1;
        for(int i = 0; i < nums.length; i++) {
            //nums[i]小于0则交换min和max的值
            if(nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            maxCur = Math.max(max, maxCur);
        }

        return maxCur;
    }
}