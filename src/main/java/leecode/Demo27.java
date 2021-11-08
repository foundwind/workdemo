package leecode;

public class Demo27 {
//

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int length = nums.length;
        for (int j = 0; j < length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

}