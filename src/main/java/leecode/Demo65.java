//package leecode;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//public class Demo65 {
////有效数字（按顺序）可以分成以下几个部分：
////
////    一个 小数 或者 整数
////    （可选）一个 'e' 或 'E' ，后面跟着一个 整数
////
////小数（按顺序）可以分成以下几个部分：
////
////    （可选）一个符号字符（'+' 或 '-'）
////    下述格式之一：
////        至少一位数字，后面跟着一个点 '.'
////        至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
////        一个点 '.' ，后面跟着至少一位数字
////
////整数（按顺序）可以分成以下几个部分：
////
////    （可选）一个符号字符（'+' 或 '-'）
////    至少一位数字
////
////部分有效数字列举如下：
////
////    ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
////
////部分无效数字列举如下：
////
////    ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
////
////来源：力扣（LeetCode）
////链接：https://leetcode-cn.com/problems/valid-number
////著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//
//    public static void main(String[] args) {
//
//    }
//
//    public boolean isNumber(String s) {
//
//    }
//
//    int actionType = 0;
//    HashSet<Character> numSet = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
//
//    public boolean checkStatus(char c) {
//        switch (actionType) {
//            case 0: // 初始位
//                if (c == '+' || c == '-') {
//                    actionType = 1;
//                    return true;
//                }
//                if (numSet.contains(c)) {
//                    actionType = 2;
//                    return true;
//                }
//                return false;
//            case 1: // +-后必须有数字
//                if (numSet.contains(c)){
//                    actionType = 2;
//                    return true;
//                }
//                return false;
//            case 2: // 数字后必须以下
//                if (numSet.contains(c)){
//                    actionType = 2;
//                    return true;
//                }
//                if (c == '.'){
//                    actionType = 3;
//                    return true;
//                }
//                if (c == 'e'){
//                    actionType = 4;
//                    return true;
//                }
//                return false;
//            case 3: // 小数点后必须有一位数字
//                if (numSet.contains(c)){
//                    actionType = 5;
//                    return true;
//                }
//                return false;
//            case 4: // e后面可以带
//
//
//
//        }
//
//
//    }
//}