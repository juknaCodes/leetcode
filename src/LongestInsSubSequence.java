import java.util.Arrays;

public class LongestInsSubSequence {
    public static void main(String args[]) {
        //int []nums = new int []{10,9,2,5,3,7,101,18};
        int[] nums = new int[] {0,1,0,3,2,3};
        lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int maxLen = 1;
        Arrays.fill(lis, 1);

        for (int i =1;i<nums.length;i++) {
            for (int j =0;j<=i;j++) { 
                if (nums[j] < nums[i])
                    lis [i] = Math.max(lis[i], lis[j]+1);
            }
            maxLen = Math.max(maxLen, lis[i]);
        }
        return maxLen;
    }
}