package jvm;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2021/11/18
 */
public class SafepointTest {

    static double sum = 0;



    public static void foo() {

        for (int i = 0; i < 0x77777777; i++) {

            sum += Math.sqrt(i);

        }

    }



    public static void bar() {

        for (int i = 0; i < 50_000_000; i++) {

            new Object().hashCode();

        }

    }



    public static void main(String[] args) {
//
//        new Thread(SafepointTest::foo).start();
//
//        new Thread(SafepointTest::bar).start();

        Integer a = null;
        System.out.println(1==a);
    }

}