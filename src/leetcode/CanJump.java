/**
 * Copyright (C), 2018-2018
 * FileName: CanJump
 * Author:   Tyson
 * Date:     2018/12/3/0003 10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.Random;

/**
 * @author Tyson
 * @create 2018/12/3/0003 10:17
 * @since 1.0.0
 */
public class CanJump {
    private static boolean canJump = false;

    public static boolean canJump(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        flag[0] = true;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(flag[j] && j + nums[j] >= i) {
                    flag[i] = true;
                    break;
                }
            }
        }

        return flag[nums.length - 1];
    }

    public static boolean myCanJump(int[] nums) {
        myCanJumpHelper(nums, 0);

        return canJump;
    }

    public static void myCanJumpHelper(int[] nums, int index) {
        if(canJump == true) {
            return;
        }

        if(index >= nums.length - 1) {
            canJump = true;
            return;
        }

        if(nums[index] == 0) {
            return;
        }

        for(int i = nums[index]; i >= 1; i--) {
            myCanJumpHelper(nums, index + i);
        }
    }

    public static boolean canJump1(int[] nums) {
        int maxJump = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(i <= maxJump && i + nums[i] >= maxJump) {
                maxJump = i + nums[i];
            }
        }

        return maxJump >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[100000];
        Random rand = new Random();
        for(int i = 0; i< nums.length; i++) {
            nums[i] = rand.nextInt(1000);
        }
        long start = System.currentTimeMillis();
        myCanJump(nums);
        long end = System.currentTimeMillis();
        System.out.println("my: " + (end - start));
        end = System.currentTimeMillis();
        canJump(nums);
        start = System.currentTimeMillis();
        System.out.println("violence: " + (start - end));

        start = System.currentTimeMillis();
        canJump1(nums);
        end = System.currentTimeMillis();
        System.out.println("greedy: " + (end - start));
    }
}