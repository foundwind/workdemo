package leecode;

public class Demo38 {
//         1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1

    public static void main(String[] args) {
        System.out.println(new Demo38().countAndSay(4));
    }


    public String countAndSay(int n) {


        String out = "1";

        for (int i = 1; i < n; i++) {
            out = tran(out);

        }

        return out;


    }

    private String tran(String outStr) {
        char[] chars = outStr.toCharArray();
        StringBuilder builder = new StringBuilder();


        int cache = chars[chars.length - 1] - '0';
        int num = 1;


        for (int i = chars.length - 2; i >= 0; i--) {
            int midNum = chars[i] - '0';
            if (midNum != cache) {
                builder.append(cache).append(num);
                cache = midNum;
                num = 1;
            } else {
                num++;
            }
        }


        builder.append(cache).append(num);

        return builder.reverse().toString();


    }

}