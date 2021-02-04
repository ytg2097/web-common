package common.exception;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public abstract class ErrorCodeRuntimeException extends RuntimeException {

    private int code;

    public ErrorCodeRuntimeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

