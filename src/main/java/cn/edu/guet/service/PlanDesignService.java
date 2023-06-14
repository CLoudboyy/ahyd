package cn.edu.guet.service;

import cn.edu.guet.bean.PlanDesignDTO;
import cn.edu.guet.bean.PlanDesignHistoryRecord;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.PlanDesignHistoryRecordDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface PlanDesignService {
    ResponseData selectRouteList();
    ResponseData createBill(PlanDesignInfo planDesignInfo);
    String getBillNo();
    ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo) throws SQLException ;
    ResponseData searchBill(PlanDesignDTO planDesignDTO);
    Long getPlanDesignIdByPlanBillNo(String planBillNo);
    ResponseData createHistoryRecord(PlanDesignHistoryRecord planDesignHistoryRecord);
}
