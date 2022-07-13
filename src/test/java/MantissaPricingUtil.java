import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 尾数定价工具类
 * <pre>
 * 实现效果：
 * - 散称商品：将斤的尾数保留到分位，且尾数处理为 8 9
 * - 标品：价格尾数保留到分位，且尾数处理为 8 9
 *
 * 具体处理逻辑：
 * - 散称商品：由于散称商品的单位为kg而不是斤，因此在计算上，步骤如下
 *  1. 需要先按价格策略计算出kg的价格（保留两位小数）
 *  2. 将该价格先除2，得出斤的价格
 *  3. 斤价格尾数如果为 0 1 2，则往数值减少的方向取 9；尾数如果为 3 4 5 6 7，则往数值增加的方向取 8
 *  4. 再用该价格*2，得出kg的价格
 *
 *  eg.
 *  1. 价格策略计算出kg价格=2.14，斤价格=1.07，往数值增加方向取8，尾数处理后斤价格=1.08，kg价格=2.16
 *  2. 价格策略计算出kg价格=6.42，斤价格=3.21，往数值减少方向取9，尾数处理后斤价格=3.19，kg价格=6.38
 *  3. 价格策略计算出kg价格=2.16，斤价格=1.08，尾数为8，不做处理
 *
 * - 标品：价格尾数保留到分位，尾数处理为 8 9，计算步骤如下
 *  1. 用价格策略计算出的价格，四舍五入到分
 *  2. 价格尾数如果为 0 1 2，则往数值减少的方向取 9；尾数如果为 3 4 5 6 7，则往数值增加的方向取 8
 *
 *  eg.
 *  1. 标品价格=2.14，往数值增加方向取8，尾数处理后价格=2.18
 *  2. 标品价格=2.12，往数值减少方向取9，尾数处理后价格=2.09
 *  3. 标品价格=2.18，尾数为9，不作处理
 * </pre>
 *
 * @author longjunhao
 * @date 2021/11/22 11:01 上午
 */
public class MantissaPricingUtil {

    /**
     * 保留的尾数
     */
    private static final List<Integer> retainList = Arrays.asList(8, 9);

    /**
     * 向下取9的尾数
     */
    private static final List<Integer> downTo9List = Arrays.asList(0, 1, 2);

    /**
     * 向上取8的尾数
     */
    private static final List<Integer> upTo8List = Arrays.asList(3, 4, 5, 6, 7);


    /**
     * 需要特殊处理的单位
     */
    private static final String KG_UNIT = "kg";

    /**
     * 保留到分（小数点后两位）
     */
    private static final int DEFAULT_SCALE = 2;

    /**
     * 四舍五入
     */
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    /**
     * 检查是否符合尾数规则，符合返回true，否则返回false
     *
     * @param salePrice
     * @param salesUnit
     * @return
     */
    public static boolean checkMantissaRule(@NotNull BigDecimal salePrice, @Nullable String salesUnit) {
        BigDecimal handleValue = handle(salePrice, salesUnit);
        return salePrice.compareTo(handleValue) == 0;
    }

    /**
     * 返回尾数处理后的价格
     *
     * @param salePrice  价格策略计算后的价格，单位元，标品价格或者kg价格
     * @param salesUnit  销售单位，当kg时，特殊处理
     * @return
     */
    public static BigDecimal handle(BigDecimal salePrice, @Nullable String salesUnit) {
        if (salePrice == null) {
            return null;
        }
        BigDecimal source;
        BigDecimal result;
        boolean kgFlag = Objects.equals(KG_UNIT, StringUtils.toRootLowerCase(salesUnit));
        if (kgFlag) {
            // 单位为kg
            // 1. 四舍五入保留两位小数（分），并且除以2，得出斤的价格（同样四舍五入保留两位小数）
            source = salePrice.setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE).divide(new BigDecimal("2"), DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
            // 2. 偏移处理
            result = handleOffset(source).multiply(new BigDecimal("2"));
        } else {
            // 单位非kg
            // 1. 四舍五入到小数点后2位（分）
            source = salePrice.setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
            // 2. 偏移处理
            result = handleOffset(source);
        }
        return result;
    }

    /**
     * 如果数字为 8 9，返回偏移 0
     * 如果数字为 0 1 2，则往数值减少的方向偏移到 9
     * 如果数字为 3 4 5 6 7，则往数值增加的方向偏移到 8
     *
     * @param value
     * @return
     */
    private static int offset(int value) {
        if (retainList.contains(value)) {
            return 0;
        }
        if (downTo9List.contains(value)) {
            return 9 - (value + 10);
        } else if (upTo8List.contains(value)) {
            return 8 - value;
        }
        return 0;
    }

    /**
     * 先把source按照roundingMode规则保留newScale
     * 再加上offset偏移值
     *
     * @param source
     * @return
     */
    private static BigDecimal handleOffset(@NotNull BigDecimal source) {
        String lastDigit = StringUtils.substring(source.toPlainString(), source.toPlainString().length() - 1);
        return source.add(source.ulp().multiply(new BigDecimal(String.valueOf(offset(Integer.parseInt(lastDigit))))));
    }

    public static void main(String[] args) {
        BigDecimal handle = MantissaPricingUtil.handle(new BigDecimal("0.0"), "");
        System.out.println(handle);
    }
}
