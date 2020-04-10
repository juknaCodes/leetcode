import sun.reflect.generics.tree.Tree;

import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
class PreorderToBST {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);

        for (int i=1;i<preorder.length;i++) {

            TreeNode node = st.peek();
            TreeNode child = new TreeNode(preorder[i]);

            while(!st.isEmpty() && st.peek().val < child.val)
                node = st.pop();

            if (node.val < child.val)
                node.right = child;
            else {
                node.left = child;
            }
            st.push(child);;
        }
        return root;

    }

    /*public TreeNode bstFromPreorderUtil(int[] preorder, int start, int end) {

        if(start > end)
            return null;
        if (start == end)
            return new TreeNode(preorder[start]);

        TreeNode root = new TreeNode(preorder[start]);
        int idx = findLastIndex(preorder, start);
        root.left = bstFromPreorderUtil(preorder, start+1, idx-1);
        root.right = bstFromPreorderUtil(preorder, idx, end);
        return root;

    }

    public int findLastIndex(int[]preorder, int start) {
        int index = start;
        while(index < preorder.length && preorder[index] <= preorder[start])
            index++;
        return index;
    }*/


}
