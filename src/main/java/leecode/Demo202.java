package leecode;

import java.util.HashSet;

public class Demo202 {
    public static void main(String[] args) {
        System.out.println(new Demo202().isHappy(2));
        System.out.println(new Demo202().isHappy(19));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int sum = 0;
            while (n != 0) {
                int sqrt = n % 10;
                n = n / 10;
                sum += sqrt * sqrt;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
    }

}