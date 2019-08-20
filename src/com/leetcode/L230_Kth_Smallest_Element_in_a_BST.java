package com.leetcode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class L230_Kth_Smallest_Element_in_a_BST {

    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, new int[]{k});
        return res;
    }

    private void dfs(TreeNode root, int[] step) {
        if (root == null) return;
        dfs(root.left, step);
        step[0]--;
        if (step[0] == 0) {
            res = root.val;
            return;
        }
        dfs(root.right, step);
    }


}
