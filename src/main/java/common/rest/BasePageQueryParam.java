package common.rest;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-06-19
 **/
public class BasePageQueryParam {

    /**
     * 页容量
     */
    private int pageSize;

    /**
     * 页码
     */
    private int pageIndex;

    public int getPageSize() {
        // 判断pageIndex是否合理
        if (this.pageSize <= 0) {
            // 获取页容量配置
            this.pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        // 判断pageIndex是否合理
        if (pageIndex <= 0) {
            return 1;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public String toString() {
        return "BasePageQueryParam{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                '}';
    }

}
