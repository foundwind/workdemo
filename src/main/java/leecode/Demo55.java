package leecode;

public class Demo55 {
//

    public static void main(String[] args) {
        System.out.println(new Demo55().canJump(new int[]{2, 0, 0}));
    }

    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果往前找都符合就报错
            if (nums[i] == 0) {
                int start = i - 1;
                // 把i继续往前推
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] == 0) {
                        i++;
                    } else {
                        break;
                    }
                }


                // 判断过程
                boolean ok = false;
                for (int j = start; j >= 0; j--) {
                    if (nums[j] > i - j) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) return false;
            }

        }

        return true;
    }
}