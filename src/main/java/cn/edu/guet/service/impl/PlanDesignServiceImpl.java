package cn.edu.guet.service.impl;

import cn.edu.guet.bean.PlanDesignHistoryRecord;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.PlanDesignHistoryRecordDao;
import cn.edu.guet.dao.PlanDesignInfoDao;
import cn.edu.guet.dao.RouteCableDao;
import cn.edu.guet.service.PlanDesignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Author huangzhouyu
 * @Data 2023/5/26 21:48
 */
public class PlanDesignServiceImpl implements PlanDesignService {

    private static Logger logger = LoggerFactory.getLogger(PlanDesignServiceImpl.class);

    private RouteCableDao routeCableDao;
    private PlanDesignInfoDao planDesignInfoDao;
    private PlanDesignHistoryRecordDao planDesignHistoryRecordDao;

    public void setRouteCableDao(RouteCableDao routeCableDao) {
        this.routeCableDao = routeCableDao;
    }

    public void setPlanDesignInfoDao(PlanDesignInfoDao planDesignInfoDao) {
        this.planDesignInfoDao = planDesignInfoDao;
    }

    public void setPlanDesignHistoryRecordDao(PlanDesignHistoryRecordDao planDesignHistoryRecordDao) {
        this.planDesignHistoryRecordDao = planDesignHistoryRecordDao;
    }

    /**
     * 查询主备路由光缆清单数据（目前无分页）
     *
     * @return
     */
    @Override
    public ResponseData selectRouteList() {
        return ResponseData.ok(routeCableDao.getObjects());
    }

    @Override
    public ResponseData createBill(PlanDesignInfo planDesignInfo) {
        try {
            int saveResult = planDesignInfoDao.save(planDesignInfo);
            if (saveResult == 1) {
                return new ResponseData("工单创建成功！");
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return ResponseData.fail("工单创建失败！");
    }

    @Override
    public String getBillNo() {
        List<String> planBillNubers = null;
        try {
            /*
            获取当天日期
             */
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String nowDate = sdf.format(date);
            logger.info("当天日期：{}", nowDate);
            planBillNubers = planDesignInfoDao.getPlanBillNo();
            if (planBillNubers.size() != 0) {
                String planBillNo = planBillNubers.get(0);
                String planBillNoDate = planBillNo.substring(9, 17);
                logger.info("数据库取出的工单号：{}", planBillNoDate);
                // 如果不相等，说明当天没有工单号，直接返回
                if (!nowDate.equals(planBillNoDate)) {
                    return "ANHD-PM-" + nowDate + "-001";
                } else {
                    String number = planBillNoDate.substring(18);
                    int no = Integer.parseInt(number);
                    no++;
                    number = String.valueOf(no);
                    if (number.length() == 1) {
                        return "ANHD-PM-" + nowDate + "-00" + number;
                    } else if (number.length() == 2) {
                        return "ANHD-PM-" + nowDate + "-0" + number;
                    } else {
                        return "ANHD-PM-" + nowDate + "-" + number;
                    }
                }
            } else {
                return "AHYD-PMS-" + nowDate + "-001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseData saveAnalyseNoAndPlanDesignId(PlanDesignHistoryRecord planDesignHistoryRecord) {
        try {
            int saveResult = planDesignHistoryRecordDao.save(planDesignHistoryRecord);
            if (saveResult == 1){
                return new ResponseData("保存成功！");
            }
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return ResponseData.fail("保存失败！");
    }

    @Override
    public Long getPlanDesignId(String planBillNo) {
        try {
            return planDesignHistoryRecordDao.getPlanDesignId(planBillNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

}
