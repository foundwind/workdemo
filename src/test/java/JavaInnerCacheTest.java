import java.lang.invoke.MethodHandles;

/**
 * @author XuYiPeng
 * @Description <描述>
 * @date 2021/11/9
 */
public class JavaInnerCacheTest {

    public static void main(String[] args) {

        Passenger a = new ChinesePassenger();

        Passenger b = new ForeignerPassenger();

        long current = System.currentTimeMillis();

        for (int i = 1; i <= 2_000_000_000; i++) {

            if (i % 1_000_000_000 == 0) {

                long temp = System.currentTimeMillis();

                System.out.println(temp - current);

                current = temp;
                MethodHandles.lookup();
            }

            Passenger c = (i < 1_000_000_000) ? a : b;

            c.passThroughImmigration();

        }

    }
}

abstract class Passenger {
    abstract void passThroughImmigration();
}
class ChinesePassenger extends Passenger {

    @Override void passThroughImmigration() {}

}

class ForeignerPassenger extends Passenger {

    @Override void passThroughImmigration() {}

}