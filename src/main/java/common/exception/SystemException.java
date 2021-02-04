package common.exception;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class SystemException extends ErrorCodeRuntimeException {
    public SystemException(int code, String message) {
        super(code, message);
    }
}
