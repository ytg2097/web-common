package common.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class RestResult<T> {

    private static final long serialVersionUID = -4827004742789377839L;

    private RestStatus status = RestStatus.SUCCESS;

    private T result;

    private Map<String, String> more = new HashMap<>();

    public RestResult() {
    }


    public RestResult(RestStatus status) {
        this.status = status;
    }

    public RestResult(T result) {
        this.result = result;
    }

    public RestResult(RestStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    public RestStatus getStatus() {
        return status;
    }

    public void setStatus(RestStatus status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Map<String, String> getMore() {
        return more;
    }

    public void setMore(Map<String, String> more) {
        this.more = more;
    }

    public void putMore(String name, String value) {
        getMore().put(name, value);
    }
}
