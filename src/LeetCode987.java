import java.util.*;

class LeetCode987 {
    class ValToIndex {
        TreeNode tNode;
        int x;
        int y;
        ValToIndex(TreeNode tNode, int x, int y) {
            this.tNode = tNode;
            this.x = x;
            this.y = y;
        }

    }

    class ValToIndexComparator implements Comparator<ValToIndex> {
        @Override
        public int compare(ValToIndex p1, ValToIndex p2) {
            if(p1.x < p2.x) return -1;
            if(p2.x < p1.x) return 1;
            if(p1.y > p2.y) return -1;
            if(p1.y < p2.y) return 1;
            return p1.tNode.val - p2.tNode.val;

        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList();
        if (root == null)
            return traversal;
        Map<Integer, PriorityQueue<ValToIndex>> verticalOrder = new TreeMap();
        ValToIndex node = new ValToIndex(root, 0, 0);

        Queue<ValToIndex> levelOrderTraversal = new LinkedList();
        levelOrderTraversal.add(node);

        while(!levelOrderTraversal.isEmpty()) {
            ValToIndex parent = levelOrderTraversal.poll();
            PriorityQueue<ValToIndex> value = verticalOrder.getOrDefault(parent.x, new PriorityQueue(new ValToIndexComparator()));
            value.add(parent);
            verticalOrder.put(parent.x, value);


            if (parent.tNode.left != null) {
                levelOrderTraversal.add(new ValToIndex(parent.tNode.left, parent.x -1, parent.y-1));
            }
            if (parent.tNode.right != null) {
                levelOrderTraversal.add(new ValToIndex(parent.tNode.right, parent.x +1, parent.y-1));
            }
        }
        int i=0;
        for(PriorityQueue<ValToIndex> level: verticalOrder.values()) {
            traversal.add(new ArrayList());
            i++;
            while (!level.isEmpty()) {
                traversal.get(i-1).add(level.poll().tNode.val);
            }

        }
        return traversal;
    }
  
    /*private void verticalTraversalUtil(TreeNode root, Map<Integer, List<Integer>>        verticalOrder, int order) {
      if (root == null)
        return;
      
      List<Integer> list = verticalOrder.getOrDefault(order, new ArrayList());      
      list.add(root.val);
      verticalOrder.put(order, list);
      verticalTraversalUtil(root.left, verticalOrder, order-1);
      verticalTraversalUtil(root.right, verticalOrder, order+1);
      
    }*/


}

class PointNode {
    int x;
    int y;
    int val;

    PointNode(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class PointComparator implements Comparator<PointNode> {

    @Override
    public int compare(PointNode p1, PointNode p2) {
        if(p1.x < p2.x) return -1;
        if(p2.x < p1.x) return 1;
        if(p1.y > p2.y) return -1;
        if(p1.y < p2.y) return 1;
        return p1.val - p2.val;
    }
}
