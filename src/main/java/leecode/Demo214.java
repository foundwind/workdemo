//package leecode;
//
//public class Demo214 {
//
//    public String shortestPalindrome(String s) {
//        // 找到最长的回文串
//        // 从左找起
//        char[] chars = s.toCharArray();
//        // 默认直接取第一个字母为
//        int startIndex = 0;
//        int endIndex = 1;
//        int maxSize = 1;
//        for (int i = chars.length - 1; i > 0; i--) {
//            if (checkIsRound(chars, 0, i)) {
//                // 如果找到了最长的回文串，反过来找
//
//                for (int j = 0; j < chars.length - i - 1 ; j++) {
//
//                }
//
//            }
//        }
//
//
//    }
//
//
//    private boolean checkIsRound(char[] chars, int start, int end) {
//        while (start < end) {
//            if (chars[start] != chars[end]) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
//}