/**
 * Created by ankujgup on 04-May-20.
 */
class LeetCode303 {

    int tree[];
    int len;

    public LeetCode303(int[] nums) {
        len = nums.length;
        tree = new int[getSize(len)];
        buildTree(nums, 0, len-1, 0);
    }
    private int getSize(int n) {
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        return 2*(int)Math.pow(2, height)-1;
    }

    public int sumRange(int i, int j) {
        return query(0, len-1, 0, i,j);
    }

    private void buildTree(int[] nums, int start, int end, int idx) {
        if (start == end) {
            tree[idx] = nums[start];
            return;
        }

        int middle = start + (end-start)/2;

        buildTree(nums, start, middle, 2*idx+1);
        buildTree(nums, middle+1, end, 2*idx+2);

        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    private int query(int start, int end, int idx, int l, int r) {
        if (l >end  || r <start) {
            return 0;
        }

        if (l<=start && end<=r) {
            return tree[idx];
        }

        int middle = start + (end-start)/2;

        int left = query(start, middle, 2*idx+1, l, r);
        int right = query(middle+1, end, 2*idx+2, l, r);
        return left+right;
    }


}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
