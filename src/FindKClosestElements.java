import java.util.*;

class DistanceInfo {
    int point;
    int distance;

    DistanceInfo(int point, int distance) {
      this.point = point;
      this.distance = distance;
    }

}
public class FindKClosestElements {

    public static void main(String args[]) {
        int[] elements = new int[] {
            1,2,3,4,5
        };
        findClosestElements( elements, 4, 3);
    }


      public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) ->
                Math.abs(e1 - x) == Math.abs(e2 - x) ? e1 - e2 : Math.abs(e1 - x) - Math.abs(e2 - x));

        for (int no : arr) {
            pq.add(no);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        Collections.sort(result);
        return result;       
        
      }
}
