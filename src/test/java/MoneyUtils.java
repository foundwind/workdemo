
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public final class MoneyUtils {

    private MoneyUtils() {
        // prevent instantiation
    }

    public static BigDecimal newQty(BigDecimal qty) {
        return qty.setScale(CommonConstant.DEFAULT_QTY_SCALE, CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal newMoneyFromLong(long number) {
        BigDecimal bd = new BigDecimal(number);
        return setScale(bd);
    }

    public static BigDecimal newMoney(String number) {
        number = StringUtils.replace(number, ",", "");
        BigDecimal bd = new BigDecimal(number);
        return setScale(bd);
    }


    public static BigDecimal newMoneyFromFloat(float number) {
        return newMoneyFromDouble((double) number);
    }

    public static BigDecimal newMoneyFromDouble(double number) {
        BigDecimal bd = new BigDecimal(number);
        return setScale(bd);
    }

    /**
     * 从int初始化金额BigDecimal
     *
     * @param number 数字
     * @return BigDecimal
     */
    public static BigDecimal newMoneyFromInt(int number) {
        BigDecimal bd = new BigDecimal(number);
        return setScale(bd);
    }

    public static BigDecimal setScale(BigDecimal bd) {
        return bd.setScale(CommonConstant.DEFAULT_SCALE, CommonConstant.DEFAULT_ROUND);
    }

    /**
     * 分转元
     *
     * @param fen
     * @return
     */
    public static BigDecimal fen2yuan(Long fen) {
        return divide(BigDecimal.valueOf(fen), BigDecimal.valueOf(100));
    }




    public static String displayMoney(BigDecimal bd) {
        String template = "\u00A5 %s";
        bd = bd.setScale(CommonConstant.DEFAULT_SCALE, CommonConstant.DEFAULT_ROUND);
        return String.format(template, bd.toString());
    }

    public static String toMoney(BigDecimal bd) {
        bd = bd.setScale(CommonConstant.DEFAULT_SCALE, CommonConstant.DEFAULT_ROUND);
        return bd.toPlainString();
    }


    public static BigDecimal add(final BigDecimal first, final BigDecimal second) {
        return add(first, second, CommonConstant.DEFAULT_SCALE);
    }

    public static BigDecimal add(final BigDecimal first, final BigDecimal... second) {
        Objects.requireNonNull(second);
        BigDecimal total = first;
        for (BigDecimal add : second) {
            total = add(total, add, CommonConstant.DEFAULT_SCALE);
        }
        return total;
    }


    public static BigDecimal add(final BigDecimal first, final BigDecimal second, Integer defaultScale) {
        if (first == null || notNull(first).equals(BigDecimal.ZERO)) {
            return notNull(second);
        } else if (second == null || notNull(second).equals(BigDecimal.ZERO)) {
            return notNull(first);
        } else {
            if (first.scale() == CommonConstant.DEFAULT_QTY_SCALE || second.scale() == CommonConstant.DEFAULT_QTY_SCALE) {
                return first.add(second).setScale(CommonConstant.DEFAULT_QTY_SCALE, CommonConstant.DEFAULT_ROUND);
            }
            return first.add(second).setScale(getSafeScale(defaultScale), CommonConstant.DEFAULT_ROUND);
        }
    }



    public static BigDecimal substract(BigDecimal first, BigDecimal second) {
        return substract(first, second, CommonConstant.DEFAULT_SCALE);
    }

    public static BigDecimal substract(BigDecimal first, BigDecimal second, Integer defaultScale) {
        if (first == null) {
            first = BigDecimal.ZERO;
        }
        if (second == null) {
            second = BigDecimal.ZERO;
        }
        if (first.scale() == CommonConstant.DEFAULT_QTY_SCALE || second.scale() == CommonConstant.DEFAULT_QTY_SCALE) {
            return first.subtract(second).setScale(CommonConstant.DEFAULT_QTY_SCALE, CommonConstant.DEFAULT_ROUND);
        }
        return first.subtract(second).setScale(getSafeScale(defaultScale), CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return multiply(first, second, CommonConstant.DEFAULT_SCALE);
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal... second) {
        return Arrays.stream(second).reduce(first, (a, b) -> multiply(a, b, CommonConstant.DEFAULT_SCALE));
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second, Integer defaultScale) {
        if (first == null || second == null) {
        }
        return first.multiply(second).setScale(getSafeScale(defaultScale), CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal multiplyQty(BigDecimal first, BigDecimal second) {
        return multiplyQty(first, second, CommonConstant.DEFAULT_SCALE);
    }

    public static BigDecimal multiplyQty(BigDecimal first, BigDecimal second, Integer defaultScale) {
        if (first == null || second == null) {
        }
        if (first.scale() == CommonConstant.DEFAULT_QTY_SCALE || second.scale() == CommonConstant.DEFAULT_QTY_SCALE) {
            return first.multiply(second).setScale(CommonConstant.DEFAULT_QTY_SCALE, CommonConstant.DEFAULT_ROUND);
        }
        return first.multiply(second).setScale(getSafeScale(defaultScale), CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal divide(BigDecimal first, BigDecimal second) {
        return divide(first, second, CommonConstant.DEFAULT_SCALE);
    }

    public static BigDecimal divide(BigDecimal first, BigDecimal second, Integer defaultScale) {
        if (first == null || second == null) {
        }
        return first.divide(second, getSafeScale(defaultScale), CommonConstant.DEFAULT_ROUND);
    }

    private static int getSafeScale(Integer scale) {
        if (scale == null) {
            return CommonConstant.DEFAULT_SCALE;
        }
        return scale;
    }

    /**
     * Get max value from given values.
     *
     * @param first  first given
     * @param second second value
     * @return max value.
     */
    public static BigDecimal max(final BigDecimal first, final BigDecimal second) {
        if (isFirstBiggerThanSecond(
                notNull(first),
                notNull(second))) {
            return notNull(first);
        }
        return notNull(second);
    }

    /**
     * Get minimal, but greater than 0 value from given values.
     *
     * @param first  first given
     * @param second second value
     * @return max value.
     */
    public static BigDecimal minPositive(final BigDecimal first, final BigDecimal second) {
        if (first == null || notNull(first).equals(BigDecimal.ZERO)) {
            return notNull(second);
        } else if (second == null || notNull(second).equals(BigDecimal.ZERO)) {
            return notNull(first);
        } else if (isFirstBiggerThanSecond(
                notNull(first),
                notNull(second))) {
            return notNull(second);
        }
        return notNull(first);
    }

    /**
     * @param value value to check
     * @return value if it not null, otherwise BigDecimal.ZERO
     */
    public static BigDecimal notNull(final BigDecimal value) {
        return notNull(value, null);
    }

    /**
     * @param value  value to check
     * @param ifNull value to return if value to check is null
     * @return value or ifNull if value is null. if ifNull is null returns BigDecimal.ZERO.
     */
    public static BigDecimal notNull(final BigDecimal value, final BigDecimal ifNull) {
        if (value == null) {
            if (ifNull == null) {
                return BigDecimal.ZERO;
            }
            return ifNull;
        }
        return value;
    }


    /**
     * @param first  value
     * @param second value
     * @return true if first is greater than second (null safe)
     */
    public static boolean isFirstBiggerThanSecond(final BigDecimal first, final BigDecimal second) {

        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return true;
        } else if (first == null) {
            return false;
        }
        return first.compareTo(second) > 0;

    }

    public static boolean isZero(final BigDecimal first) {
        if (first == null) {
            return false;
        }

        return isFirstEqualToSecond(first, CommonConstant.ZERODECIMAL);

    }

    public static boolean isBiggerThanZero(final BigDecimal first) {
        return first != null && isFirstBiggerThanSecond(first, CommonConstant.ZERODECIMAL);

    }

    public static boolean isFirstBiggerThanOrEqualToZero(final BigDecimal first) {
        return first != null && isFirstBiggerThanOrEqualToSecond(first, CommonConstant.ZERODECIMAL);

    }

    /**
     * @param first  value
     * @param second value
     * @return true if first is greater than or equal to second (null safe)
     */
    public static boolean isFirstBiggerThanOrEqualToSecond(final BigDecimal first, final BigDecimal second) {
        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return true;
        } else if (first == null) {
            return false;
        }

        return first.compareTo(second) >= 0;
    }

    /**
     * @param first  value
     * @param second value
     * @return true if first is equal to second (null safe)
     */
    public static boolean isFirstEqualToSecond(final BigDecimal first, final BigDecimal second) {
        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return false;
        } else if (first == null) {
            return false;
        }

        return first.compareTo(second) == 0;
    }

    /**
     * @param first  value
     * @param second value
     * @param scale  scale
     * @return true if first is equal to second (null safe)
     */
    public static boolean isFirstEqualToSecond(final BigDecimal first, final BigDecimal second, final int scale) {
        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return false;
        } else if (first == null) {
            return false;
        }
        return first.setScale(scale).compareTo(second.setScale(scale)) == 0;

    }

    /**
     * Get discount as percentage.
     * E.g. original 100.00, discounted 80.0 - the result will be 80 (%)
     * E.g. original 100.00, discounted 80.99 - the result will be 80 (%)
     *
     * @param original   original price
     * @param discounted discounted price
     * @return discount in percent
     */
    public static BigDecimal getDiscountDisplayValue(final BigDecimal original, final BigDecimal discounted) {
        if (original == null || discounted == null) {
            return BigDecimal.ZERO;
        }
        return discounted.multiply(CommonConstant.HUNDREDDECIMAL)
                .divide(original, CommonConstant.DEFAULT_ROUND).setScale(0, CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal newMoneyQty(String qty) {
        if (StringUtils.isBlank(qty)) {
        }
        BigDecimal bd = new BigDecimal(qty);
        return bd.setScale(CommonConstant.DEFAULT_QTY_SCALE, CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal displayQty(BigDecimal qty) {
        if (qty == null) {
        }
        return qty.multiply(CommonConstant.HUNDREDDECIMAL).setScale(CommonConstant.DEFAULT_SCALE, CommonConstant.DEFAULT_ROUND);
    }

    public static BigDecimal fromDisplayQty(String qty) {
        BigDecimal newQty = newMoneyQty(qty);
        return newQty.divide(CommonConstant.HUNDREDDECIMAL, CommonConstant.DEFAULT_QTY_SCALE, CommonConstant.DEFAULT_ROUND);
    }

    /**
     * 将数字转换为取出所有末尾0的自然数表达的文字，比如 2.00 -> 2 2.10 -> 2.1
     * 如果数字为null，返回空字符串
     *
     * @param amount 数字
     * @return 字符串表达
     */
    public static String toNoTrailingZerosString(BigDecimal amount) {
        if (amount == null) {
            return StringUtils.EMPTY;
        }

        return amount.stripTrailingZeros().toPlainString();
    }

}
