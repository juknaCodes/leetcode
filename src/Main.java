import java.util.ArrayList;
import java.util.Arrays;

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
      Graph g = new Graph(6);
      g.addEdge(5, 2);
      g.addEdge(5, 0);
      g.addEdge(4, 0);
      g.addEdge(4, 1);
      g.addEdge(2, 3);
      g.addEdge(3, 1);
      System.out.println("Following is a Topological Sort");
      g.topologicalSort();
    }

}
