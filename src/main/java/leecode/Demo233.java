package leecode;

// 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//
//
//
//示例 1：
//
//输入：n = 13
//输出：6
//
//示例 2：
//
//输入：n = 0
//输出：0
//
//
//
//提示：
//
//    0 <= n <= 109

import javax.annotation.Resource;

public class Demo233 {

    @Resource
    private Demo231 demo231;

    public static void main(String[] args) {
        Demo233 demo233 = new Demo233();
        System.out.println(demo233.demo231);
    }

    public int countDigitOne(int n) {
        return 1;
    }
}