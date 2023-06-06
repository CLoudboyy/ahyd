package cn.edu.guet.dao;

import cn.edu.guet.bean.PlanDesignInfo;

import java.sql.SQLException;
import java.util.List;

public interface PlanDesignInfoDao extends BaseDao<PlanDesignInfo> {
    List<String> getPlanBillNo() throws SQLException;
}
