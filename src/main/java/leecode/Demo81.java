package leecode;

public class Demo81 {
//

    public static void main(String[] args) {
        new Demo81().search(new int[]{1, 1}, 0);
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (left == right) return nums[left] == target;
        return dfs(left, right, nums, target);
    }

    private boolean dfs(int left, int right, int[] nums, int target) {
        if (left == right) return false;
        int mid = (left + right) / 2;
        if (nums[left] == target || nums[mid] == target || nums[right] == target) return true;

        if (nums[left] == nums[mid] && nums[right] == nums[mid]) return dfs(left + 1, right - 1, nums, target);

        if (target > nums[left]) {
            return dfs(left, mid - 1, nums, target);
        } else {
            return dfs(mid + 1, right, nums, target);
        }
    }
}