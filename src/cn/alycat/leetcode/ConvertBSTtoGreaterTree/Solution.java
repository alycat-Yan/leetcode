package cn.alycat.leetcode.ConvertBSTtoGreaterTree;

import cn.alycat.leetcode.TreeNode;

public class Solution {


    /**
     *
     * Given a Binary Search Tree (BST),
     * convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater
     * than the original key in BST.
     *
     * Example:
     *
     * Input: The root of a Binary Search Tree like this:
     *               5
     *             /   \
     *            2     13
     *
     * Output: The root of a Greater Tree like this:
     *              18
     *             /   \
     *           20     13
     * */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    private int sum = 0;

    public static void main(String[] args) {
//        [2,0,3,-4,1]
        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(0);
        root.right=new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        root = new Solution().convertBST(root);
        System.out.println(root);
    }
}
