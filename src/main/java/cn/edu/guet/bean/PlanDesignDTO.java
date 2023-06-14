package cn.edu.guet.bean;

/**
 * @Author liwei
 * @Date 2023/6/6 19:51
 * @Version 1.0
 */

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 搜索工单DTO（Data Transfer Object：数据传输对象，前端传数据给后端）
 */
public class PlanDesignDTO {
    private String planDesignName;
    private Integer specId;
    private String designer;
    private List<Timestamp> createTime;
    private Integer size;
    private Integer current;

    public String getPlanDesignName() {
        return planDesignName;
    }

    public void setPlanDesignName(String planDesignName) {
        this.planDesignName = planDesignName;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public List<Timestamp> getCreateTime() {
        return createTime;
    }

    public void setCreateTime(List<Timestamp> createTime) {
        this.createTime = createTime;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "PlanDesignDTO{" +
                "planDesignName='" + planDesignName + '\'' +
                ", specId=" + specId +
                ", designer='" + designer + '\'' +
                ", createTime=" + createTime +
                ", size=" + size +
                ", current=" + current +
                '}';
    }
}
