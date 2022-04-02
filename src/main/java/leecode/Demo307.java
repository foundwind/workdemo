package leecode;

public class Demo307 {
//

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));

    }


    static class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = new int[nums.length + 1];

            for (int i = 1; i < nums.length + 1; i++) {
                this.nums[i] = this.nums[i - 1] + nums[i - 1];
            }
        }

        public void update(int index, int val) {
            int oldVal = nums[index + 1] - nums[index];
            int dif = val - oldVal;
            for (int i = index + 1; i < nums.length; i++) {
                nums[i] = nums[i] + dif;
            }
        }

        public int sumRange(int left, int right) {
            return nums[right + 1] - nums[left];
        }
    }


}
