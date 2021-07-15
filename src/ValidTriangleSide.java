import java.util.*;

public class ValidTriangleSide {
    public static void main(String args[]) {
        int []nums = new int[]{4,2,3,4};
        triangleNumber(nums);
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count =0;

        for (int i =2;i< nums.length;i++) {
            int start = 0;
            int end = i-1;

            while(start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    count += (end-start);
                    end--;
                } else { 
                    start++;
                }
            }
        }

        return count;

    }
} 