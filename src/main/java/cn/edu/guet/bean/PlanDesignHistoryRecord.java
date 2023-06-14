package cn.edu.guet.bean;

import cn.hutool.core.date.DateTime;

import java.sql.Timestamp;

/**
 * @Author huangzhouyu
 * @Data 2023/6/5 15:04
 */
public class PlanDesignHistoryRecord {
    private Long id;
    private Long plan_design_id;
    private String analyse_no;
    private Integer analyse_status;
    private Timestamp create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlan_design_id() {
        return plan_design_id;
    }

    public void setPlan_design_id(Long plan_design_id) {
        this.plan_design_id = plan_design_id;
    }

    public String getAnalyse_no() {
        return analyse_no;
    }

    public void setAnalyse_no(String analyse_no) {
        this.analyse_no = analyse_no;
    }

    public Integer getAnalyse_status() {
        return analyse_status;
    }

    public void setAnalyse_status(Integer analyse_status) {
        this.analyse_status = analyse_status;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "PlanDesignHistoryRecord{" +
                "id=" + id +
                ", plan_design_id=" + plan_design_id +
                ", analyse_no='" + analyse_no + '\'' +
                ", analyse_status=" + analyse_status +
                ", create_time=" + create_time +
                '}';
    }
}
