public class FindPeakElement {
    public static void main(String args[]) {
        int [] nums = {2,1};
        findPeakElement(nums);
    }
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
          return 0;
        if (nums.length == 2) {
          if (nums[0] > nums[1])
            return 0;
          else 
            return 1;
        }

        int low=0, high = nums.length-1;
        int middle;
        while(low<high) {
            middle = low + (high-low)/2;

            if ( middle > 0 && nums[middle] > nums[middle-1] &&  
            middle < nums.length-1 && nums[middle] > nums[middle+1]) {
                return middle;
            } else if(middle > 0 && nums[middle] > nums[middle-1] && middle < nums.length-1 && nums[middle]<nums[middle+1]) {      
                low = middle+1;     //move left to mid+1 as nums[mid+1] > nums[mid], thus our answer  lies on right side
            }
            else{
                high=middle;         // move right to mid as either nums[mid-1] is more than nums[mid] or nums[mid] is more than nums[mid+1] 
            }
        }
        return low;
        
    }
}
