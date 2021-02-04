package common.rest;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class RestStatus {

    public static final int CODE_SUCCESS = 0;

    /**
     * 成功状态
     */
    public static final RestStatus SUCCESS = new RestStatus(CODE_SUCCESS, "success");

    private int code;
    private String msg;

    public RestStatus() {
    }

    public RestStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
