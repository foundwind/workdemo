package leecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Demo7 {
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//示例 1:
//
//输入: 123
//输出: 321
//
// 示例 2:
//
//输入: -123
//输出: -321
//
//示例 3:
//
//输入: 120
//输出: 21
//
//注意:
//
//假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
//

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Demo7().reverse(-2147483412));
    }

    public int reverse(int x) {
        boolean flag = x < 0;


        int max = Integer.MAX_VALUE / 10;
        int maR = Integer.MAX_VALUE % 10;
        int min = Integer.MIN_VALUE / 10;
        int minR = Integer.MIN_VALUE % 10;


        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (flag) {
                //负数
                if (result < min || result == min && pop < minR) return 0;
            } else {
                //正数
                if (result > max || result == max && pop > maR ) return 0;

            }
            result = result * 10 + pop;

        }
        return result;

    }

}