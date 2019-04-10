/**
 * Copyright (C), 2018-2018
 * FileName: Sum3
 * Author:   Tyson
 * Date:     2018/8/5/0005 16:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tyson
 * @create 2018/8/5/0005
 * @since 1.0.0
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int target;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int m = i + 1;
            int n = nums.length - 1;

            while(m < n) {
                if(nums[m] + nums[n] < (-1) * nums[i]) {
                    m++;
                } else if(nums[m] + nums[n] > (-1) * nums[i]) {
                    n--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);

                    result.add(list);

                    while(m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    while(m < n && nums[n] == nums[n - 1]) {
                        n--;
                    }

                    m++;
                    n--;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list = new Sum3().threeSum(new int[] {-1, 0, 1});

        for(List<Integer> listArr : list) {
            Integer[] arr = listArr.toArray(new Integer[0]);
            System.out.println(Arrays.toString(arr));
        }
    }
}