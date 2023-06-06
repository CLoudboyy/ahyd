package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.PlanDesignHistoryRecord;
import cn.edu.guet.dao.PlanDesignHistoryRecordDao;
import cn.edu.guet.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangzhouyu
 * @Data 2023/6/5 15:19
 */
public class PlanDesignHistoryRecordDaoImpl extends BaseDaoImpl<PlanDesignHistoryRecord> implements PlanDesignHistoryRecordDao {
    @Override
    public Long getPlanDesignId(String planBillNo) throws SQLException {
        // 写JDBC代码
        Connection conn = DBConnection.getConn();
        String sql = "SELECT id FROM PlanDesignInfo WHERE plan_bill_no = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,planBillNo);
        ResultSet rs = pstmt.executeQuery();
        Long id = 0L;
        while (rs.next()) {
            id = rs.getLong(1);
        }
        return id;
    }
}
