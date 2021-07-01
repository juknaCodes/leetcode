import java.util.*;

public class GrayCodeLeetcode89 {

    public static void main(String args[]) {
        grayCode(2);
    }

    public static List<Integer> grayCode(int n) {
      
        List<Integer> grayCodes = new ArrayList();
        grayCodes.add(0);

        for (int i = 1;i<=n;i++) {
            int size = grayCodes.size(), base = 1 <<(i-1);

            for (int j = size-1;j>=0;j--) {
                grayCodes.add(grayCodes.get(j) + base);
            }
        }

        return grayCodes;
          
    }
    /*public static List<Integer> grayCode(int n) {
      
        int max = (int)Math.pow(2, n);
        List<Integer> grayCodes = new ArrayList<Integer>();
        grayCodes.add(0);      
        int lastAdded = 0;
        int count = 1;
        boolean [] isAdded = new boolean[max];
        isAdded[0] = true;
        while(count <= max) {
          for (int i=1;i<=max-1;i++) {
            if (isAdded[i]) {
              continue;
            }
            if (isDiffByOneBit(lastAdded, i)) {
              lastAdded = i;
              isAdded[i] = true;
              grayCodes.add(i);
              break;
            }          
          }
          count++;
        }
        return grayCodes;
          
      }*/
    
      public static boolean isDiffByOneBit(int a, int b) {
        return isPowerOfTwo(a^b);
      }
    
      static boolean isPowerOfTwo(int x)
      {
          // First x in the below expression is
          // for the case when x is 0
          return (x !=0) && ((x & (x - 1)) == 0);
      }
}
