package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Page;
import cn.edu.guet.bean.PlanDesignDTO;
import cn.edu.guet.bean.PlanDesignHistoryRecord;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.PlanDesignHistoryRecordDao;
import cn.edu.guet.dao.PlanDesignInfoDao;
import cn.edu.guet.dao.RouteCableDao;
import cn.edu.guet.service.PlanDesignService;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


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
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(new Date(now));
        Timestamp createTime = Timestamp.valueOf(formattedDate);
        Timestamp updateTime = Timestamp.valueOf(formattedDate);
        planDesignInfo.setCreate_time(createTime);
        planDesignInfo.setUpdate_time(updateTime);
        try {
            int saveResult = planDesignInfoDao.save(planDesignInfo);
            if (saveResult == 1) {
                return new ResponseData("工单创建成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseData.fail("工单创建失败！");
    }

    @Override
    public String getBillNo() {
        List<String> planBillNumbers = null;
        try {
            /*
            获取当天日期
             */
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String nowDate = sdf.format(date);
            planBillNumbers = planDesignInfoDao.getPlanBillNo();
            // 数据库没有任何记录
            if (planBillNumbers.size() != 0) {
                String planBillNo = planBillNumbers.get(0);
                String planBillNoDate = planBillNo.substring(9, 17);
                logger.info("planBillNoDate:{}", planBillNoDate);
                logger.info("nowDate:{}", nowDate);
                // 如果不相当，说明当天还没有工单
                if (!nowDate.equals(planBillNoDate)) {
                    return "AHYD-PMS-" + nowDate + "-001";
                } else {
                    String number = planBillNo.substring(18);
                    int no = Integer.parseInt(number);
                    no++;
                    number = String.valueOf(no);
                    if (number.length() == 1) {
                        return "AHYD-PMS-" + planBillNoDate + "-00" + no;
                    } else if (number.length() == 2) {
                        return "AHYD-PMS-" + planBillNoDate + "-0" + no;
                    } else {
                        return "AHYD-PMS-" + planBillNoDate + "-" + no;
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
    public ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo) throws SQLException {
         /*
        1、保存工单
        2、调用解析接口
         */
        // 保存工单
        createBill(planDesignInfo);

        Map<String, Object> map = new HashMap<>(8);
        map.put("systemCADFilePath", planDesignInfo.getSystem_cad_file_url());
        map.put("systemExcelFilePath", planDesignInfo.getSystem_excel_file_url());
        map.put("channelExcelFilePath", planDesignInfo.getChannel_excel_file_url());
        map.put("planBillNo", planDesignInfo.getPlan_bill_no());
        map.put("cadCoordLeft", planDesignInfo.getCad_coord_left());
        map.put("cadCoordTop", planDesignInfo.getCad_coord_top());
        map.put("cadCoordRight", planDesignInfo.getCad_coord_right());
        map.put("cadCoordBottom", planDesignInfo.getCad_coord_bottom());


        String queryJson = new Gson().toJson(map);
        Map<String, String> heads = new HashMap<>(1);
        heads.put("Content-Type", "application/json;charset=UTF-8");
        HttpResponse response = HttpRequest.post("http://localhost:9999/analyseCADCallApi")
                .headerMap(heads, false)
                .body(queryJson)
                .timeout(5 * 60 * 100)
                .execute();
        ResponseData responseData = new Gson().fromJson(response.body(), ResponseData.class);
        logger.info(responseData.getCode() + "");
        logger.info(responseData.getMessage());
        logger.info(responseData.getData() + "");


        /*
        将analyseNo、plan_design_no、create_time和analyse_status存入planDesignHistoryRecord表中
         */
        Map<String, Object> dataMap = (Map<String, Object>) responseData.getData();
        String analyseNo = (String) dataMap.get("analyseNo");
        String planBillNo = (String) dataMap.get("planBillNo");
        logger.info("planBillNo:{}",planBillNo);
        // Long planDesignId = getPlanDesignIdByPlanBillNo(planBillNo);
        Long planDesignId = planDesignInfoDao.getPlanDesignIdByPlanBillNo(planBillNo);
        PlanDesignHistoryRecord planDesignHistoryRecord = new PlanDesignHistoryRecord();
        planDesignHistoryRecord.setPlan_design_id(planDesignId);
        planDesignHistoryRecord.setAnalyse_no(analyseNo);
        // 创建时间
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(new Date(now));
        Timestamp createTime = Timestamp.valueOf(formattedDate);
        planDesignHistoryRecord.setCreate_time(createTime);
        planDesignHistoryRecord.setAnalyse_status(1);


        // 保存历史分析表
        planDesignHistoryRecordDao.save(planDesignHistoryRecord);
        return responseData;
    }

    @Override
    public ResponseData searchBill(PlanDesignDTO planDesignDTO) {
        Page<PlanDesignInfo> pagination = null;
        try {
            pagination = planDesignInfoDao.searchBill(planDesignDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseData.ok(pagination);
    }

    @Override
    public Long getPlanDesignIdByPlanBillNo(String planBillNo) {
        try {
            Long planDesignId = planDesignInfoDao.getPlanDesignIdByPlanBillNo(planBillNo);
            return planDesignId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseData createHistoryRecord(PlanDesignHistoryRecord planDesignHistoryRecord) {

        return null;
    }
}
