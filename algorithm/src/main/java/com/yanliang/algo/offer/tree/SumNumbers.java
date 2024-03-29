package com.yanliang.algo.offer.tree;

/**
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和 https://leetcode-cn.com/problems/3Etpl5/
 *
 * <p>给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *
 * <p>每条从根节点到叶节点的路径都代表一个数字：
 *
 * <p>例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * <p>叶节点 是指没有子节点的节点。
 *
 * <p>示例 1：
 *
 * <p>输入：root = [1,2,3] 输出：25 解释： 从根到叶子节点路径 1->2 代表数字 12 从根到叶子节点路径 1->3 代表数字 13 因此，数字总和 = 12 + 13 =
 * 25 示例 2：
 *
 * <p>输入：root = [4,9,0,5,1] 输出：1026 解释： 从根到叶子节点路径 4->9->5 代表数字 495 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 * <p>提示：
 *
 * <p>树中节点的数目在范围 [1, 1000] 内 0 <= Node.val <= 9 树的深度不超过 10
 *
 * @author yanliang
 */
public class SumNumbers {

    private static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        dfs(root, 0);
        return sum;
    }

    public static void dfs(TreeNode root, int num) {
        if (root == null) return;
        // 组装数字
        num = num * 10 + root.val;
        // 如果是叶子节点，进行累加
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        // 向左下遍历
        dfs(root.left, num);
        // 向右下遍历
        dfs(root.right, num);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
