import java.util.*;
public class ArraySizeToHalf {
    public static void main(String[] args) {
        int[] arr = new int[] {2,28,92,30,100,52,28,48,91,27,66,19,11,53,91,95,74,51,65,65,96,81,21,55,98,3,2,89,99,57,78,34,50,2,57,76,23,90,89,36,53,22,73,59,95,45};
        minSetSize(arr);
    }
    public static int minSetSize(int[] arr) {
      
        Map<Integer, Integer> frequencyMap = new HashMap();
        for (int i:arr) {
          frequencyMap.put(i, frequencyMap.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
          public int compare(Integer e1, Integer e2) {
            return frequencyMap.get(e2) - frequencyMap.get(e1);
          }
        });

        for (Integer i : frequencyMap.keySet()) {
            pq.add(i);
        }
        
        int count = 0;
        int size = arr.length;
        while(!pq.isEmpty()) {            
          count++;
          size-= frequencyMap.get(pq.poll());
          if (size <= arr.length/2)
            return count;
        }

        // for(Integer ele : pq) {
        //     count++;
        //     size-= frequencyMap.get(ele);
        //     if (size <= arr.length/2)
        //         return count;
        // }
        
        return -1;        
      }
    
}
