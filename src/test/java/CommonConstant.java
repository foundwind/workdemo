import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CommonConstant {

    public static final BigDecimal HUNDREDDECIMAL = new BigDecimal("100.00").setScale(CommonConstant.DEFAULT_SCALE,
            BigDecimal.ROUND_HALF_UP);

    public static final BigDecimal ZERODECIMAL = new BigDecimal("0.00").setScale(CommonConstant.DEFAULT_SCALE,
            BigDecimal.ROUND_HALF_UP);
    public static final BigDecimal ONEDECIMAL = new BigDecimal("1.00").setScale(CommonConstant.DEFAULT_SCALE,
            BigDecimal.ROUND_HALF_UP);
    /**
     * 用于控制日结逻辑全局生效时间 任务id 7087
     */
    public static final LocalDate ORDER_SETTLE_TIME_7087 = LocalDate.of(2021, 5, 12);

    public static final String EmptyString = "";
    public static final String SYSTEM_USER = "system";

    public static final String DEFAULT_OPTION_VALUE = EmptyString;
    public static final String DEFAULT_OPTION_TEXT = "请选择";
    public static final String SHOP_ALL_ID = "****";
    public static final String SHOP_ALL_TEXT = "全部门店";
    public static final String SERVICE_STARTED_LOG_TEXT = "Bootstrap started successfully";
    /**
     * Default decimal scale
     */
    public static final int DEFAULT_SCALE = 2;
    public static final int DEFAULT_QTY_SCALE = 4;
    /**
     * 香港舍分逻辑时使用精度
     */
    /**
     * Default decimal ROUND
     */
    public static final int DEFAULT_ROUND = BigDecimal.ROUND_HALF_UP;

    /**
     * Predefined Http Code
     */

    public static final String EXCPETION_LOGGER = "exception.logger";

    public static final String REQUEST_CONTENT_LOGGER = "requestcontext.logger";

    public static final String RESPONSE_CONTENT_LOGGER = "responsecontext.logger";

    public static final String TRANSACTION_TRACKING_LOGGER = "transaction_tracking.logger";

    public static final String TRANSACTION_TRACKING_STEP_LOGGER = "transaction_tracking_step.logger";

    public static final String MESSAGE_LOGGER = "message.logger";

    public static final String MQTT_LOGGER = "mqtt.logger";

    public static final String LOGLEVEL_WARN = "WARN";
    public static final String LOGLEVEL_ERROR = "ERROR";

    public static final String WEB_TOKEN = "token";

    public static final String SPLIT = "~";

    /**
     * RSA的密钥生成算法
     */
    public static final String KEY_GENERATE_ALGORITHM_RSA = "RSA";
    /**
     * SHA1withRSA的签名算法
     */
    public static final String SIGN_TYPE_SHA1WITHRSA = "SHA1withRSA";

    public static final SerializerFeature[] COMMON_JSON_FEATURE = new SerializerFeature[]{
            SerializerFeature.DisableCircularReferenceDetect,
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty,
            //SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullStringAsEmpty
    };
}