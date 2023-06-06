package cn.edu.guet.bean;

import java.sql.Timestamp;

/**
 * @Author huangzhouyu
 * @Data 2023/5/26 21:25
 */


public class PlanDesignRouteCable {
    private Long id;
    private Long plan_design_id;
    private Long plan_design_result_id;
    private String cable_seg_name;
    private String station_a;
    private String station_z;
    private String cable_name;
    private Integer is_main_backup;
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

    public Long getPlan_design_result_id() {
        return plan_design_result_id;
    }

    public void setPlan_design_result_id(Long plan_design_result_id) {
        this.plan_design_result_id = plan_design_result_id;
    }

    public String getCable_seg_name() {
        return cable_seg_name;
    }

    public void setCable_seg_name(String cable_seg_name) {
        this.cable_seg_name = cable_seg_name;
    }

    public String getStation_a() {
        return station_a;
    }

    public void setStation_a(String station_a) {
        this.station_a = station_a;
    }

    public String getStation_z() {
        return station_z;
    }

    public void setStation_z(String station_z) {
        this.station_z = station_z;
    }

    public String getCable_name() {
        return cable_name;
    }

    public void setCable_name(String cable_name) {
        this.cable_name = cable_name;
    }

    public Integer getIs_main_backup() {
        return is_main_backup;
    }

    public void setIs_main_backup(Integer is_main_backup) {
        this.is_main_backup = is_main_backup;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
