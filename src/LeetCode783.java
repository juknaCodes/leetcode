/**
 * Created by ankujgup on 30-Apr-20.
 */
public class LeetCode783 {

    int diff = Integer.MAX_VALUE;
    TreeNode predecessor = null;
    public int minDiffInBST(TreeNode root) {
        minDiffInBSTUtil(root);
        return diff;
    }

    private void minDiffInBSTUtil(TreeNode root) {
        if (root == null)
            return;
        minDiffInBSTUtil(root.left);

        if (predecessor != null) {
            System.out.println(predecessor.val);
            System.out.println(root.val);
            diff = Math.min(diff, Math.abs(predecessor.val - root.val));

        }

        predecessor = root;
        //System.out.println(predecessor.val);
        minDiffInBSTUtil(root.right);

    }
}
