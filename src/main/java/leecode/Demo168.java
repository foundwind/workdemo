package leecode;

import java.math.BigDecimal;

public class Demo168 {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(1);
        for (int i = 1; i < 31; i++) {
            decimal = decimal.multiply(new BigDecimal(i));
        }
        System.out.println(decimal);
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(convert(columnNumber % 26));
        int now = columnNumber / 26;
        while (now != 0) {
            sb.append(convert(columnNumber % 26));
        }
        return "";
    }

    public String convert(int num) {
        if (num == 0) return "";
        return ((char) ('A' + num - 1)) + "";
    }

}