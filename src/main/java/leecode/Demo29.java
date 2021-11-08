package leecode;

public class Demo29 {
//

    public static void main(String[] args) {
        System.out.println(new Demo29().divide(Integer.MAX_VALUE, 3));
    }

    int MIN = Integer.MIN_VALUE >> 1;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            }
        }
        int sign = 1;
        if (dividend <= 0 && divisor > 0) sign = -1;
        if (dividend > 0 && divisor < 0) sign = -1;

        int result = 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        result = round(dividend, divisor);


        return sign * result;

    }

    private int round(int dividend, int divisor) {

        if (dividend > divisor) {
            return 0;
        }
        if (dividend == divisor) {
            return 1;
        }

        int count = 1;
        int div = divisor;


        while (true) {
            if (div < MIN) break;
            int cache = div + div;
            if (cache == dividend) return count + count;
            if (cache < dividend) break;
            div = cache;
            count = count + count;
        }

        return count + round(dividend - div , divisor);

    }
}