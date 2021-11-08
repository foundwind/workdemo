package demo.json;

import java.time.LocalDateTime;

public class JsonDemmo {


    private static final String PATTERN = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static void main(String[] args) throws Exception {
        highToLow();
        String.format("商品%s存在调拨单，无法发起退货，或者商品存在调拨，或者商品%s在近30天没有对应已确认并且验收数量大于0和验收金额大于0的验收单", "123");
    }

    public static void calculate() throws Exception {

    }

    public static void highToLow() throws Exception{
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusYears(1);
        int num = localDateTime1.getDayOfYear();
        int count = 0;
        int current = num;

        StringBuilder result = new StringBuilder();
        while(count < 2 && current >= 0) {
            result.append(PATTERN.charAt(current % 36));
            current = current / 36;
            count ++;
        }
        result.setLength(2);
        result.reverse();
        System.out.println(result.toString());

    }
}