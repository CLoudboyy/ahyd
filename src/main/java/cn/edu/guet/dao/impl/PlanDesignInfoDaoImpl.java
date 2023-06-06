package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.dao.PlanDesignInfoDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangzhouyu
 * @Data 2023/5/27 15:37
 */
public class PlanDesignInfoDaoImpl extends BaseDaoImpl<PlanDesignInfo> implements PlanDesignInfoDao {
    @Override
    public List<String> getPlanBillNo() throws SQLException {
        // 写JDBC代码
        Connection conn = DBConnection.getConn();
        String sql = "SELECT plan_bill_no FROM PlanDesignInfo ORDER BY plan_bill_no DESC";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<String> planBillNumbers = new ArrayList<>();
        while (rs.next()) {
            String planBillNo = rs.getString(1);
            planBillNumbers.add(planBillNo);
        }

        return planBillNumbers;
    }
}
