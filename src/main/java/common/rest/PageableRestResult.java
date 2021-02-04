package common.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class PageableRestResult<T>{

    private PageInfo pageInfo;

    private RestStatus status = RestStatus.SUCCESS;

    private List<T> result;


    public RestStatus getStatus() {
        return status;
    }

    public void setStatus(RestStatus status) {
        this.status = status;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Map<String, String> getMore() {
        return more;
    }

    public void setMore(Map<String, String> more) {
        this.more = more;
    }

    private Map<String, String> more = new HashMap<>();

    public PageableRestResult() {
    }

    public PageableRestResult(RestStatus status) {
        this.status = status;
    }

    public PageableRestResult(List<T> result, long totalElements, int totalPages) {
        this.result = result;
        this.pageInfo = new PageInfo(totalElements, totalPages);
    }

    public PageableRestResult(RestStatus status, List<T> result, long totalElements, int totalPages) {

        this.status = status;
        this.result = result;
        this.pageInfo = new PageInfo(totalElements, totalPages);
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
