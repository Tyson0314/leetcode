/**
 * Copyright (C), 2018-2018
 * FileName: CombinationSum
 * Author:   Tyson
 * Date:     2018/12/5/0005 16:18
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
 * @create 2018/12/5/0005 16:18
 * @since 1.0.0
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        for(int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumHelper(result, list, candidates, i, target);
            list.clear();
        }

        return result;
    }

    public void combinationSumHelper(List<List<Integer>> result, List<Integer> list, int[] arr, int index, int target) {
        target -= arr[index];

        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            combinationSumHelper(result, list, arr, i, target);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> result = cs.combinationSum(arr, 8);

        for(List<Integer> list : result) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}