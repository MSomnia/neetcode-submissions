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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        // put root into the queue
        queue.offer(root);

        while (!queue.isEmpty())
        {
            //get the number of nodes in the curret level
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i=0; i< levelSize; i++)
            {
                //extract the node
                TreeNode node = queue.poll();
                level.add(node.val);

                //put the nodes from the next level into the queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }
        return result;
    }
}
