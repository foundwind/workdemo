package leecode;

import utils.MD5Utils;

import java.math.BigDecimal;

public class Demo724 {
//

    public static void main(String[] args) {
        String md5 = "a";
        while (true){
            String s = MD5Utils.md5(md5);
        }
    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2*sum + nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}