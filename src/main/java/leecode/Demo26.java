package leecode;

public class Demo26 {
//

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int cache = nums[0];
        int index = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] != cache) {
                cache = nums[i];
                nums[index++] = cache;
            }
        }
        return index;
    }

}