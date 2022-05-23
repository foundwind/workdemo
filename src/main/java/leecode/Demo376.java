package leecode;

public class Demo376 {
    public static void main(String[] args) {
        System.out.println(new Demo376().wiggleMaxLength(new int[]{0, 0}));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
                continue;
            }
            // 上线序列
            if (nums[i - 1] > nums[i]) {
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
                up[i] = up[i - 1];
            } else {
                up[i] = Math.max(down[i - 1] + 1, up[i - 1]);
                down[i] = down[i - 1];
            }

        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);

    }


}
