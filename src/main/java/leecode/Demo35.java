package leecode;

public class Demo35 {
//

    public static void main(String[] args) {
        System.out.println(new Demo35().searchInsert(new int[]{1,3,5}, 4));
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        if (nums[0] >= target) return 0;
        if (nums[len - 1] == target) return len - 1;
        if (nums[len - 1] < target) return len;

        for (int i = 1; i < len - 1; i++) {
            if (nums[i] >= target) return i;
        }
        return len - 1;
    }
}