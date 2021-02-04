package common.rest;

import static common.rest.RestStatus.CODE_SUCCESS;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-12-22
 **/
public class ResultAssert {

    public static boolean assertSucc(RestResult restResult){

        return CODE_SUCCESS == restResult.getStatus().getCode();
    }

    public static boolean assertSucc(RestStatus status){

        return CODE_SUCCESS == status.getCode();
    }

    public static boolean assertSucc(PageableRestResult restResult){

        return CODE_SUCCESS == restResult.getStatus().getCode();
    }

    public static boolean assertFail(PageableRestResult restResult){

        return !assertSucc(restResult);
    }

    public static boolean assertFail(RestStatus status){

        return !assertSucc(status);
    }

    public static boolean assertFail(RestResult restResult){

        return !assertSucc(restResult);
    }
}
