package common.exception;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class BusinessException extends ErrorCodeRuntimeException {

    public BusinessException(int code, String message) {
        super(code, message);
    }

    public BusinessException(Exception e){
        super(e.getCode(),e.getDescription());
    }

    public interface Exception{

        int getCode();

        String getDescription();
    }
}
