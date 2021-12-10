package leecode;

public class Demo91 {
//

    public static void main(String[] args) {

    }


    int count = 0;

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        // 0-n,有多少种解码方式
        int[] dd = new int[len + 1];
        // 填充最后一个
        char c = s.charAt(len - 1);
        if (c == '0'){

        }




        // 从最后走到头
        for (int i = len - 1; i > -1; i++) {

        }


        return dd[0];
    }
}