package cn.edu.guet.dao;

import cn.edu.guet.bean.PlanDesignHistoryRecord;

import java.sql.SQLException;

public interface PlanDesignHistoryRecordDao extends BaseDao<PlanDesignHistoryRecord> {
    Long getPlanDesignId(String planBillNo) throws SQLException;
}
