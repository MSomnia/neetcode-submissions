/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(isSameTree(root, subRoot)) return true;

        //向下探寻。用or因为只要有一边是一样的就可以
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 递归函数进tree
    boolean isSameTree(TreeNode a, TreeNode b)
    {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;

        //向下探寻。用and因为两棵树相同必须要左右都一样
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
