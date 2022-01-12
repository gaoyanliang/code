package com.yanliang.algo.offer.tree;

/**
 * 剑指 Offer II 054. 所有大于等于节点的值之和 https://leetcode-cn.com/problems/w6cpku/
 *
 * <p>给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * <p>提醒一下，二叉搜索树满足下列约束条件：
 *
 * <p>节点的左子树仅包含键 小于 节点键的节点。 节点的右子树仅包含键 大于 节点键的节点。 左右子树也必须是二叉搜索树。
 *
 * <p>示例 1：
 *
 * <p>输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8] 示例 2：
 *
 * <p>输入：root = [0,null,1] 输出：[1,null,1] 示例 3：
 *
 * <p>输入：root = [1,0,2] 输出：[3,3,2] 示例 4：
 *
 * <p>输入：root = [3,2,4,1] 输出：[7,9,4,10]
 *
 * <p>提示：
 *
 * <p>树中的节点数介于 0 和 104 之间。 每个节点的值介于 -104 和 104 之间。 树中的所有值 互不相同 。 给定的树为二叉搜索树。
 *
 * @author yanliang
 */
public class ConvertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);
        }
        return root;
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
