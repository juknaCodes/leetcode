import java.util.*;

public class Main {


  /**
   * Your LRUCache object will be instantiated and called as such:
   * LRUCache obj = new LRUCache(capacity);
   * int param_1 = obj.get(key);
   * obj.put(key,value);
   */

    public static void main(String[] args) {
      /*AlienDictionary ss = new AlienDictionary();

      /*["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]*/

      /*[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483647,-2147483648,
      null,-2147483648]
       */
      /*Expected [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,
      null,2147483647]
       */

      /*ss.alienOrder(new String[]{"wrt",
  "wrf",
  "er",
  "ett",
  "rftt"});
      //ss.alienOrder(new String[]{"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"});
    }*/

      // Create a graph given in the above diagram
      /*Graph g = new Graph(6);
      g.addEdge(5, 2);
      g.addEdge(5, 0);
      g.addEdge(4, 0);
      g.addEdge(4, 1);
      g.addEdge(2, 3);
      g.addEdge(3, 1);
      System.out.println("Following is a Topological Sort");
      g.topologicalSort();*/

      /*LeetCode1319 ss = new LeetCode1319();
      int[][] edges = new int[4][2];

      edges[0][0] = 0;
      edges[0][1] = 1;
      edges[1][0] = 0;
      edges[1][1] = 2;
      edges[2][0] = 0;
      edges[2][1] = 3;
      edges[3][0] = 1;
      edges[3][1] = 2;
      //edges[4][0] = 1;
      //edges[4][1] = 3;

      ss.makeConnected(6, edges);*/
      /*LeetCode317 ss = new LeetCode317();
      int[][] edges = new int[3][5];

      edges[0][0]=0;
      edges[0][1]=2;
      edges[0][2]=1;
      edges[0][3]=0;
      edges[0][4]=1;
      edges[1][0]=1;
      edges[1][1]=0;
      edges[1][2]=2;
      edges[1][3]=0;
      edges[1][4]=0;
      edges[2][0]=0;
      edges[2][1]=1;
      edges[2][2]=0;
      edges[2][3]=0;
      edges[2][4]=0;


      ss.shortestDistance(edges);*/
      LeetCode783 ss = new LeetCode783();

      /*root.left = new TreeNode(2);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(3);

      root.right.left = new TreeNode(2);
      root.right.left.right = new TreeNode(3);
      root.right.left.right.left = new TreeNode(4);
      root.right.left.right.right = new TreeNode(8);
      root.right.left.right.left.left = new TreeNode(6);
      root.right.left.right.left.left.left = new TreeNode(7);*/
      TreeNode root = new TreeNode(27);
      //root.left = new TreeNode(3);
     // root.left.right = new TreeNode(1);
      root.right = new TreeNode(34);
      //root.left.left = new TreeNode(1);

      //root.left.right = new TreeNode(6);
      //root.left.right.left = new TreeNode(4);
      //root.left.right.right = new TreeNode(7);
      root.right.right = new TreeNode(58);
      root.right.right.left = new TreeNode(50);
      root.right.right.left.left = new TreeNode(44);

      //root.left.left.right.left = new TreeNode(6);

     /* root.left.left.left.right.left = new TreeNode(10);
      root.left.left.left.right.right = new TreeNode(8);
      root.left.left.right.left.left = new TreeNode(11);
      root.left.left.right.left.right = new TreeNode(9);*/
      int[][] costs = new int[][] {
              {8,16,12,18,9},
              {19,18,8,2,8},
              {8,5,5,13,4},
              {15,9,3,19,2},
              {8,7,1,8,17},
              {8,2,8,15,5},
              {8,17,1,15,3},
              {8,8,5,5,16},
              {2,2,18,2,9}
      };
      //ss.minCostII(costs);
      ss.minDiffInBST(root);
/*
      ClassA z = new ClassA(10);
      ClassB x = new ClassB(10,20);
      System.out.println(z.equals(x));
      System.out.println(x.equals(z));*/

      /*PriorityQueue<PointNode> queue = new PriorityQueue<>(new PointComparator());
      PointNode p1 = new PointNode(-2, -2, 3);
      queue.add(p1);
      PointNode p2 = new PointNode(-2, -4, 7);
      queue.add(p2);
      PointNode p3 = new PointNode(-2, -4, 6);
      queue.add(p3);
      while(!queue.isEmpty())
        System.out.println(queue.poll().val);*/

      /*PriorityQueue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());

      queue.add(2);
      queue.add(5);
      queue.add(7);
      queue.add(4);
      queue.add(6);
      while(!queue.isEmpty())
        System.out.println(queue.poll());*/

    }


}
