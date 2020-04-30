/**
 * Created by ankujgup on 27-Apr-20.
 */
public class LeetCode1026 {
    class MinMax {
        int min;
        int max;

        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        MinMax res = new MinMax();
        maxAncestorDiffUtil(root, res);
        return Math.abs(res.min-res.max);

    }

    public void maxAncestorDiffUtil(TreeNode root, MinMax res) {
        if(root.left ==null && root.right == null) {
            res.max = root.val;
            res.min = root.val;
            return;
        }

        if (root.left != null && root.right != null) {
            MinMax left = new MinMax();
            MinMax right = new MinMax();

            maxAncestorDiffUtil(root.left, left);
            maxAncestorDiffUtil(root.right, right);

            res.max = Math.max(Math.max(left.max, right.max), res.max);
            res.min = Math.min(Math.min(left.min, right.min), res.min);
        } else if (root.left != null) {
            MinMax left = new MinMax();
            maxAncestorDiffUtil(root.left, left);
            res.max = Math.max(left.max, res.max);
            res.min = Math.min(left.min, res.min);
        } else {
            MinMax right = new MinMax();
            maxAncestorDiffUtil(root.right, right);
            res.max = Math.max(right.max, res.max);
            res.min = Math.min(right.min, res.min);
        }

    }
}
