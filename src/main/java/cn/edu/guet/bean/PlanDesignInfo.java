package cn.edu.guet.bean;

import cn.hutool.core.date.DateTime;

/**
 * @Author liwei
 * @Date 2023/5/27 13:32
 * @Version 1.0
 */
public class PlanDesignInfo {

    private Long id;
    private String plan_bill_no;
    private String plan_design_name;
    private String design_company;
    private Integer spec_id;
    private String project_director;
    private String spec_leader;
    private String designer;
    private String reviewer;
    private Integer source;
    private Integer system_cad_file_id;
    private String system_cad_file_name;
    private String system_cad_file_url;
    private Integer system_excel_file_id;
    private String system_excel_file_name;
    private String system_excel_file_url;
    private Integer channel_excel_file_id;
    private String channel_excel_file_name;
    private String channel_excel_file_url;
    private String cad_coord_left;
    private String cad_coord_top;
    private String cad_coord_right;
    private String cad_coord_bottom;
    private DateTime create_time;
    private DateTime update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlan_bill_no() {
        return plan_bill_no;
    }

    public void setPlan_bill_no(String plan_bill_no) {
        this.plan_bill_no = plan_bill_no;
    }

    public String getPlan_design_name() {
        return plan_design_name;
    }

    public void setPlan_design_name(String plan_design_name) {
        this.plan_design_name = plan_design_name;
    }

    public String getDesign_company() {
        return design_company;
    }

    public void setDesign_company(String design_company) {
        this.design_company = design_company;
    }

    public Integer getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Integer spec_id) {
        this.spec_id = spec_id;
    }

    public String getProject_director() {
        return project_director;
    }

    public void setProject_director(String project_director) {
        this.project_director = project_director;
    }

    public String getSpec_leader() {
        return spec_leader;
    }

    public void setSpec_leader(String spec_leader) {
        this.spec_leader = spec_leader;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getSystem_cad_file_id() {
        return system_cad_file_id;
    }

    public void setSystem_cad_file_id(Integer system_cad_file_id) {
        this.system_cad_file_id = system_cad_file_id;
    }

    public String getSystem_cad_file_name() {
        return system_cad_file_name;
    }

    public void setSystem_cad_file_name(String system_cad_file_name) {
        this.system_cad_file_name = system_cad_file_name;
    }

    public String getSystem_cad_file_url() {
        return system_cad_file_url;
    }

    public void setSystem_cad_file_url(String system_cad_file_url) {
        this.system_cad_file_url = system_cad_file_url;
    }

    public Integer getSystem_excel_file_id() {
        return system_excel_file_id;
    }

    public void setSystem_excel_file_id(Integer system_excel_file_id) {
        this.system_excel_file_id = system_excel_file_id;
    }

    public String getSystem_excel_file_name() {
        return system_excel_file_name;
    }

    public void setSystem_excel_file_name(String system_excel_file_name) {
        this.system_excel_file_name = system_excel_file_name;
    }

    public String getSystem_excel_file_url() {
        return system_excel_file_url;
    }

    public void setSystem_excel_file_url(String system_excel_file_url) {
        this.system_excel_file_url = system_excel_file_url;
    }

    public Integer getChannel_excel_file_id() {
        return channel_excel_file_id;
    }

    public void setChannel_excel_file_id(Integer channel_excel_file_id) {
        this.channel_excel_file_id = channel_excel_file_id;
    }

    public String getChannel_excel_file_name() {
        return channel_excel_file_name;
    }

    public void setChannel_excel_file_name(String channel_excel_file_name) {
        this.channel_excel_file_name = channel_excel_file_name;
    }

    public String getChannel_excel_file_url() {
        return channel_excel_file_url;
    }

    public void setChannel_excel_file_url(String channel_excel_file_url) {
        this.channel_excel_file_url = channel_excel_file_url;
    }

    public String getCad_coord_left() {
        return cad_coord_left;
    }

    public void setCad_coord_left(String cad_coord_left) {
        this.cad_coord_left = cad_coord_left;
    }

    public String getCad_coord_top() {
        return cad_coord_top;
    }

    public void setCad_coord_top(String cad_coord_top) {
        this.cad_coord_top = cad_coord_top;
    }

    public String getCad_coord_right() {
        return cad_coord_right;
    }

    public void setCad_coord_right(String cad_coord_right) {
        this.cad_coord_right = cad_coord_right;
    }

    public String getCad_coord_bottom() {
        return cad_coord_bottom;
    }

    public void setCad_coord_bottom(String cad_coord_bottom) {
        this.cad_coord_bottom = cad_coord_bottom;
    }

    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }

    public DateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(DateTime update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "PlanDesignInfo{" +
                "id=" + id +
                ", plan_bill_no='" + plan_bill_no + '\'' +
                ", plan_design_name='" + plan_design_name + '\'' +
                ", design_company='" + design_company + '\'' +
                ", spec_id=" + spec_id +
                ", project_director='" + project_director + '\'' +
                ", spec_leader='" + spec_leader + '\'' +
                ", designer='" + designer + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", source=" + source +
                ", system_cad_file_id=" + system_cad_file_id +
                ", system_cad_file_name='" + system_cad_file_name + '\'' +
                ", system_cad_file_url='" + system_cad_file_url + '\'' +
                ", system_excel_file_id=" + system_excel_file_id +
                ", system_excel_file_name='" + system_excel_file_name + '\'' +
                ", system_excel_file_url='" + system_excel_file_url + '\'' +
                ", channel_excel_file_id=" + channel_excel_file_id +
                ", channel_excel_file_name='" + channel_excel_file_name + '\'' +
                ", channel_excel_file_url='" + channel_excel_file_url + '\'' +
                ", cad_coord_left='" + cad_coord_left + '\'' +
                ", cad_coord_top='" + cad_coord_top + '\'' +
                ", cad_coord_right='" + cad_coord_right + '\'' +
                ", cad_coord_bottom='" + cad_coord_bottom + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
