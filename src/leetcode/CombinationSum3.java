/**
 * Copyright (C), 2018-2019
 * FileName: CombinationSum3
 * Author:   Tyson
 * Date:     2019/5/10/0010 10:23
 * Description:
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyson
 * @ClassName: CombinationSum3
 * @create 2019/5/10/0010 10:23
 */
class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(k, n, 1, list, result);

        return result;
    }

    public void combinationSumHelper(int k, int n, int index, List<Integer> list,  List<List<Integer>> res) {
        if (n < 0 || k < 0) {
            return;
        }
        if (n == 0 && k == 0) {
            //list重新构造
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i <= n && k > 0 && n > 0; i++) {
            list.add(i);
            combinationSumHelper(k - 1, n - i, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        cs3.combinationSum3(3, 7);
    }
}