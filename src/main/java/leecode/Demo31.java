package leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Demo31 {
//

    public static void main(String[] args) {
        Demo31 demo31 = new Demo31();
//        demo31.nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
        demo31.nextPermutation(new int[]{1,3,2});

    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                //往后找出第二小的
               Arrays.sort(nums,i,len);
                for (int j = i; j < len; j++) {
                    if (nums[i - 1] < nums[j] ) {
                        int mid = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = mid;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);

    }

}