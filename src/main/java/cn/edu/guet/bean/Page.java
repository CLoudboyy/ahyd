package cn.edu.guet.bean;

import java.util.List;

/**
 * @Author liwei
 * @Date 2023/6/7 21:22
 * @Version 1.0
 */
public class Page<T>{
    // 当前页
    private Integer current;
    // 总记录数
    private Integer total;
    // 每页记录数
    private Integer size;
    // 总页数
    private Integer pages;

    private List<T> records;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
