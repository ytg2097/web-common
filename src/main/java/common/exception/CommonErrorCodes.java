package common.exception;

/**
 * @description:
 *      10000 - 19999: 系统异常
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class CommonErrorCodes {

    /**
     * 系统错误
     */
    public static final int SYSTEM_ERROR = 10001;
    /**
     * 认证失败
     */
    public static final int AUTHENTICATION_FAIL = 10004;
    /**
     * 参数处理失败
     */
    public static final int PARSE_PARAMETERS_ERROR = 10005;
    /**
     * 参数验证失败
     */
    public static final int VALIDATE_PARAMETERS_ERROR = 10006;
    /**
     * 请勿重复操作
     */
    public static final int REPETITIVE_OPERATION_ERROR = 10007;
    /**
     * 数据已过期，请刷新后重新操作
     */
    public static final int DATA_OUT_OF_DATE = 10008;
    /**
     * 不支持的读取
     */
    public static final int UN_SUPPORTED_READ = 10009;
    /**
     * 未知异常
     */
    public static final int UNKNOWN_ERROR = -1;
}
