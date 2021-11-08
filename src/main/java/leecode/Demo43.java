package leecode;

public class Demo43 {
//

    public static void main(String[] args) {
        String a=  "b";
        System.out.println(a.substring(1,a.length()));
        System.out.println(new Demo43().multiply("0", "123213"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int length1 = num1.length();
        int length2 = num2.length();

        int[] arrays = new int[length1 + length2];

        for (int i = length1 - 1; i > -1; i--) {
            for (int j = length2 - 1; j > -1; j--) {
                int one = num1.charAt(i) - '0';
                int two = num2.charAt(j) - '0';
                arrays[i + j + 1] += one * two;
            }
        }
        int cache = 0;
        for (int i = length1 + length2 - 1; i > -1; i--) {
            arrays[i] += cache;
            cache = arrays[i] / 10;
            arrays[i] = arrays[i] % 10;
        }
        int start = arrays[0] == 0 ? 1 : 0;
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < length1 + length2; i++) {
            builder.append(arrays[i]);
        }
        return builder.toString();
    }

}