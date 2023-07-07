package cn.edu.guet.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Cad数据映射类
 *
 * @Author liwei
 * @Date 2023/5/4 18:39
 * @Version 1.0
 */

public class CadData {
    private String analyseNo;
    private String analyseStatus;
    private List<PlanDesignRouteCable> routeCable;
    private List<PlanDesignPhysicsRoute> physicsRoute;
    private List<PlanDesignBusinessRoute> businessRoute;
    private List<PlanDesignCadDrawing> cadDrawing;
    private List<PlanDesignExcelRecord> excelRecord;
    private List<PlanDesignConsistencyResult> consistencyResult;

    public String getAnalyseNo() {
        return analyseNo;
    }

    public void setAnalyseNo(String analyseNo) {
        this.analyseNo = analyseNo;
    }

    public String getAnalyseStatus() {
        return analyseStatus;
    }

    public void setAnalyseStatus(String analyseStatus) {
        this.analyseStatus = analyseStatus;
    }

    public List<PlanDesignRouteCable> getRouteCable() {
        return routeCable != null ? routeCable : new ArrayList<PlanDesignRouteCable>();
    }

    public void setRouteCable(List<PlanDesignRouteCable> routeCable) {
        this.routeCable = routeCable;
    }

    public List<PlanDesignPhysicsRoute> getPhysicsRoute() {
        return physicsRoute != null ? physicsRoute : new ArrayList<PlanDesignPhysicsRoute>();
    }

    public void setPhysicsRoute(List<PlanDesignPhysicsRoute> physicsRoute) {
        this.physicsRoute = physicsRoute;
    }

    public List<PlanDesignBusinessRoute> getBusinessRoute() {
        return businessRoute != null ? businessRoute : new ArrayList<PlanDesignBusinessRoute>();
    }

    public void setBusinessRoute(List<PlanDesignBusinessRoute> businessRoute) {
        this.businessRoute = businessRoute;
    }

    public List<PlanDesignCadDrawing> getCadDrawing() {
        return cadDrawing != null ? cadDrawing : new ArrayList<PlanDesignCadDrawing>();
    }

    public void setCadDrawing(List<PlanDesignCadDrawing> cadDrawing) {
        this.cadDrawing = cadDrawing;
    }

    public List<PlanDesignExcelRecord> getExcelRecord() {
        return excelRecord != null ? excelRecord : new ArrayList<PlanDesignExcelRecord>();
    }

    public void setExcelRecord(List<PlanDesignExcelRecord> excelRecord) {
        this.excelRecord = excelRecord;
    }

    public List<PlanDesignConsistencyResult> getConsistencyResult() {
        return consistencyResult != null ? consistencyResult : new ArrayList<PlanDesignConsistencyResult>();
    }

    public void setConsistencyResult(List<PlanDesignConsistencyResult> consistencyResult) {
        this.consistencyResult = consistencyResult;
    }
}
