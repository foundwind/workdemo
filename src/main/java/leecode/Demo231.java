package leecode;

public class Demo231 {

    public static void main(String[] args) {
        System.out.println(new Demo231().isPowerOfTwo(-2147483648));
    }

    public boolean isPowerOfTwo(int n) {
        if (n<0) return false;
        return Integer.bitCount(n) == 1;
    }
}