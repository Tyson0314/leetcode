/**
 * Copyright (C), 2018-2018
 * FileName: SymmetricTree
 * Author:   Tyson
 * Date:     2018/12/24/0024 9:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;


/**
 * @author Tyson
 * @create 2018/12/24/0024 9:37
 * @since 1.0.0
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            return isSymmetricHelper(left.right, right.left) &&
                    isSymmetricHelper(left.left, right.right);
        }

        return false;
    }

    public void printTree(TreeNode root) {

    }

    public static TreeNode buileTree(int[] arr, int i) {
        TreeNode root = new TreeNode(arr[i]);

        if (i * 2 + 1 < arr.length) {
            root.left = buileTree(arr, i * 2 + 1);
        }

        if (i * 2 + 2 < arr.length) {
            root.right = buileTree(arr, i * 2 + 2);
        }

        return root;
    }

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3};
        TreeNode root = buileTree(arr, 0);

        System.out.println(isSymmetric(root));
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
