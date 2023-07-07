package cn.edu.guet.bean;

import java.io.Serializable;
import java.util.Date;

public class PlanDesignConsistencyResult implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.Id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.plan_design_id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private Long planDesignId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.plan_design_result_id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private Long planDesignResultId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.analys_cad_num
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private Integer analysCadNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.analys_excel_num
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private Integer analysExcelNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.analys_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private String analysResult;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_plan_design_consistency_result.create_time
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.Id
     *
     * @return the value of t_plan_design_consistency_result.Id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.Id
     *
     * @param id the value for t_plan_design_consistency_result.Id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.plan_design_id
     *
     * @return the value of t_plan_design_consistency_result.plan_design_id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public Long getPlanDesignId() {
        return planDesignId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withPlanDesignId(Long planDesignId) {
        this.setPlanDesignId(planDesignId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.plan_design_id
     *
     * @param planDesignId the value for t_plan_design_consistency_result.plan_design_id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setPlanDesignId(Long planDesignId) {
        this.planDesignId = planDesignId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.plan_design_result_id
     *
     * @return the value of t_plan_design_consistency_result.plan_design_result_id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public Long getPlanDesignResultId() {
        return planDesignResultId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withPlanDesignResultId(Long planDesignResultId) {
        this.setPlanDesignResultId(planDesignResultId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.plan_design_result_id
     *
     * @param planDesignResultId the value for t_plan_design_consistency_result.plan_design_result_id
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setPlanDesignResultId(Long planDesignResultId) {
        this.planDesignResultId = planDesignResultId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.analys_cad_num
     *
     * @return the value of t_plan_design_consistency_result.analys_cad_num
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public Integer getAnalysCadNum() {
        return analysCadNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withAnalysCadNum(Integer analysCadNum) {
        this.setAnalysCadNum(analysCadNum);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.analys_cad_num
     *
     * @param analysCadNum the value for t_plan_design_consistency_result.analys_cad_num
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setAnalysCadNum(Integer analysCadNum) {
        this.analysCadNum = analysCadNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.analys_excel_num
     *
     * @return the value of t_plan_design_consistency_result.analys_excel_num
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public Integer getAnalysExcelNum() {
        return analysExcelNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withAnalysExcelNum(Integer analysExcelNum) {
        this.setAnalysExcelNum(analysExcelNum);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.analys_excel_num
     *
     * @param analysExcelNum the value for t_plan_design_consistency_result.analys_excel_num
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setAnalysExcelNum(Integer analysExcelNum) {
        this.analysExcelNum = analysExcelNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.analys_result
     *
     * @return the value of t_plan_design_consistency_result.analys_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public String getAnalysResult() {
        return analysResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withAnalysResult(String analysResult) {
        this.setAnalysResult(analysResult);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.analys_result
     *
     * @param analysResult the value for t_plan_design_consistency_result.analys_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setAnalysResult(String analysResult) {
        this.analysResult = analysResult == null ? null : analysResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_plan_design_consistency_result.create_time
     *
     * @return the value of t_plan_design_consistency_result.create_time
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public PlanDesignConsistencyResult withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_plan_design_consistency_result.create_time
     *
     * @param createTime the value for t_plan_design_consistency_result.create_time
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_consistency_result
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", planDesignId=").append(planDesignId);
        sb.append(", planDesignResultId=").append(planDesignResultId);
        sb.append(", analysCadNum=").append(analysCadNum);
        sb.append(", analysExcelNum=").append(analysExcelNum);
        sb.append(", analysResult=").append(analysResult);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}