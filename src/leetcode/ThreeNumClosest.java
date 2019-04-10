/**
 * Copyright (C), 2018-2018
 * FileName: ThreeNumClosest
 * Author:   Tyson
 * Date:     2018/8/5/0005 17:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/8/5/0005
 * @since 1.0.0
 */
public class ThreeNumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }

        int clostest = nums[0] + nums[1] + nums[2];
        int sum;

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                sum = nums[i] + nums[k] + nums[j];
                if(Math.abs(target - sum) < Math.abs(target - clostest)) {
                    clostest = sum;
                }
                j++;
                k--;
            }
        }

        return clostest;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeNumClosest().threeSumClosest(new int[] {1, 1, -1, -1, 3}, 3));
    }
}