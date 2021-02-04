package common.rest;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class PageInfo {

    private long totalElements;

    private int totalPages;

    public PageInfo() {
    }

    public PageInfo(long totalElements, int totalPages) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
