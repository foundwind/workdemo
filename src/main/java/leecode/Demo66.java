package leecode;

public class Demo66 {
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/plus-one
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        boolean upFlag = false;
        if (digits[digits.length - 1] == 9) {
            digits[digits.length - 1] = 0;
            upFlag = true;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        }

        if (upFlag == false) return digits;

        for (int i = digits.length - 2; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                upFlag = true;
            } else {
                digits[i] = digits[i] + 1;
                upFlag = false;
                break;
            }
        }
        if (upFlag){
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            int index = 1;
            for (int digit : digits) {
                ints[index++] = digit;
            }
            return ints;
        }else {
            return digits;
        }
    }

}