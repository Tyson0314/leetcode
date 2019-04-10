/**
 * Copyright (C), 2018-2019
 * FileName: KthPermutation
 * Author:   Tyson
 * Date:     2019/1/17/0017 17:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyson
 * @create 2019/1/17/0017 17:27
 * @since 1.0.0
 */
class KthPermutation {
    public List<String> getPermutation(int n, int k) {
        char[] arr = new char[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (char)('0' + i + 1);
        }

        List<String> result = new ArrayList<>();
        getPermutationHelper(result, arr, 0);

        return result;
    }

    public void getPermutationHelper(List<String> result, char[] arr, int index) {
        if(index >= arr.length - 1) {
            result.add(new String(arr));
            return;
        }

        for(int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            getPermutationHelper(result, arr, index + 1);
            swap(arr, index, i);
        }
    }

    public void swap(char[] arr, int x, int y) {
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }


    public static void main(String[] args) {
        KthPermutation kp = new KthPermutation();

        List<String> list = kp.getPermutation(3, 3);

        for(String str : list) {
            System.out.println(str);
        }
    }
}