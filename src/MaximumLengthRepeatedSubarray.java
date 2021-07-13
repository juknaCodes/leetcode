import java.util.Arrays;

public class MaximumLengthRepeatedSubarray {

    public static void main(String args[]) {
        int [] nums1 = new int[] {1,2,3,2,1};
        int [] nums2 = new int[] {3,2,1,4,7};
        System.out.println(findLength(nums1, nums2));
    }
    //Top Down Recursive DP
/*
    public static int findLength(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length != 0)
            return 0;
        if (nums1.length != 0 && nums2.length == 0)
            return 0;  

        return findLengthUtil(nums1, nums2, 0, 0, 0);        
    }

    public static int findLengthUtil(int[] nums1, int[] nums2, int idx1, int idx2, int count) {
        if (idx1>= nums1.length || idx2 >= nums2.length)
            return count;
        
        int same = count;
        if(nums1[idx1] == nums2[idx2]) {
            same = findLengthUtil(nums1, nums2, idx1+1, idx2+1, count+1);
        }
        
        return Math.max(Math.max(same,  findLengthUtil(nums1, nums2, idx1+1, idx2, 0)), 
            findLengthUtil(nums1, nums2, idx1, idx2+1, 0));        
    }
    */
    // Top Down Memo
    public static int findLength(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length != 0)
            return 0;
        if (nums1.length != 0 && nums2.length == 0)
            return 0;  
        int[][] memo = new int[nums1.length][nums2.length];

        for (int i=0;i<nums1.length;i++) {
            Arrays.fill(memo[i], -1);
        }
        return findLengthUtil(nums1, nums2, 0, 0, 0, memo);        
    }

    public static int findLengthUtil(int[] nums1, int[] nums2, int idx1, int idx2, int count, int[][] memo) {
        if (idx1>= nums1.length || idx2 >= nums2.length)
            return count;

        if (memo[idx1][idx2] != -1)
            return memo[idx1][idx2] ;
        
        int same = count;
        if(nums1[idx1] == nums2[idx2]) {
            same = findLengthUtil(nums1, nums2, idx1+1, idx2+1, count+1, memo);
        }
        
        memo[idx1][idx2] =  Math.max(Math.max(same,  findLengthUtil(nums1, nums2, idx1+1, idx2, 0, memo)), 
            findLengthUtil(nums1, nums2, idx1, idx2+1, 0, memo)); 
        return memo[idx1][idx2];
    }
    /*
    //Bottom UP DP
    public int findLength(int[] X, int[] Y) {
        int memo[][] = new int[X.length + 1][Y.length + 1];
          int result = 0;
    
          for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
              if (i == 0 || j == 0) {
                memo[i][j] = 0;
              } else if (X[i - 1] == Y[j - 1]) {
                memo[i][j] = memo[i - 1][j - 1] + 1;
                result = Math.max(result, memo[i][j]);
              } else {
                memo[i][j] = 0;
              }
            }
          }
          return result;
      }
      */
}
