package leecode;

public class Demo80 {
//

    public static void main(String[] args) {
        new Demo80().removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2});
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 3) return 2;
        // 删除的数据
        int left = 0;
        int right = 1;

        while (true) {
            // 当前left的数量
            int cacheCount = 1;
            if (nums[left] == nums[right]) {
                // 继续往右找
                cacheCount++;
                while (nums[left] == nums[right + 1]) {
                    cacheCount++;
                    right++;
                    if (right + 1 == length) {
                        return length - cacheCount + 2;
                    }
                }
            }
            if (cacheCount > 2) { // 需要把数据往左迁移
                left = left + +2;// 迁移点
                right = left + cacheCount - 2;

                for (int i = 0; i < length - right; i++) {
                    nums[left + i] = nums[right + i];
                }
                // 扣除长度
                length = length - cacheCount + 2;
                right = left + 1;
            } else {
                left += cacheCount;
                right = left + 1;
            }

            if (right >= length - 1) {
                return length;
            }
        }

    }

}