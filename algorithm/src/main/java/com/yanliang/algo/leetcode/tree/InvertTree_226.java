package com.yanliang.algo.leetcode.tree;

/**
 * leetcode - 226 反转链表
 *
 * <p>翻转一棵二叉树。
 *
 * <p>示例：
 *
 * <p>输入：
 *
 * <p>4 / \ 2 7 / \ / \ 1 3 6 9 输出：
 *
 * <p>4 / \ 7 2 / \ / \ 9 6 3 1
 *
 * @author yanliang
 * @date 11/27/2020 9:11 AM
 */
public class InvertTree_226 {

    public PreorderTraversal.TreeNode invertTree(PreorderTraversal.TreeNode root) {
        if (root == null) {
            return root;
        }

        PreorderTraversal.TreeNode left = invertTree(root.left);
        PreorderTraversal.TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
