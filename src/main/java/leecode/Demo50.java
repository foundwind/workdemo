package leecode;

public class Demo50 {
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

    public static void main(String[] args) {
    }

    double myPow(double x, int n) {
        if (n == 0) return 1;

        double sum = 1;
        boolean revert = false;

        double concat = 1;
        if (n == Integer.MIN_VALUE) {
            n = Integer.MIN_VALUE + 1;
            concat = x;
        }

        if (n < 0) {
            revert = true;
            n = -n;
        }

        int range = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                sum *= x;
            }
            x *= x;
            n = n >> 1;
        }
        sum *= concat;


        if (revert) return 1 / sum;
        return sum;
    }

}