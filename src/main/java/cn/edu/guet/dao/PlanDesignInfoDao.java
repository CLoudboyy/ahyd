package cn.edu.guet.dao;


import cn.edu.guet.bean.Page;
import cn.edu.guet.bean.PlanDesignDTO;
import cn.edu.guet.bean.PlanDesignInfo;

import java.sql.SQLException;
import java.util.List;

public interface PlanDesignInfoDao extends BaseDao<PlanDesignInfo> {
    List<String> getPlanBillNo() throws SQLException;
    Page<PlanDesignInfo> searchBill(PlanDesignDTO planDesignDTO) throws SQLException;

    Long getPlanDesignIdByPlanBillNo(String planBillNo) throws SQLException;
}
