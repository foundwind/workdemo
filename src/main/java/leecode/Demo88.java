package leecode;

public class Demo88 {
//

    public static void main(String[] args) {
        new Demo88().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int len = m + n;
        int oneIndex = m - 1;
        int twoIndex = n - 1;
        for (int i = len; i > -1; i--) {
            if (oneIndex == -1 || twoIndex == -1) {

            } else {

            }

        }

    }
}