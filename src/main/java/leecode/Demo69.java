package leecode;

public class Demo69 {
//由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
//示例 1：
//
//输入：x = 4
//输出：2
//
//示例 2：
//
//输入：x = 8
//输出：2
//解释：8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sqrtx
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println();
        System.out.println(new Demo69().mySqrt(4));
    }

    public int mySqrt(int x) {
        if (x == 1) return 0;
        int left = 0;
        int right = x;

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if ((long) (mid * mid) > x) {
                right = mid;
            } else {
                left = mid;
            }

        }
        return left;
    }


}