package common.exception;

import static common.exception.CommonErrorCodes.REPETITIVE_OPERATION_ERROR;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class RepetitiveOperationException extends SystemException {

    public RepetitiveOperationException() {
        super(REPETITIVE_OPERATION_ERROR, "System Error : " + REPETITIVE_OPERATION_ERROR);
    }
}
