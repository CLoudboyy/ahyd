package cn.edu.guet.service;

import cn.edu.guet.bean.Page;
import cn.edu.guet.bean.PlanDesignDTO;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;

/**
* @author Cloud
* @description 针对表【t_plan_design_info(规划设计评估主表)】的数据库操作Service
* @createDate 2023-06-16 12:58:54
*/
public interface PlanDesignInfoService {

    ResponseData selectBusinessRouteByPlanDesignId(Long id);

    ResponseData selectRouteCableList(Long id);

    ResponseData createBill(PlanDesignInfo planDesignInfo);

    ResponseData parseCAD();

    String getBillNo();

    ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo);

    ResponseData searchBill(PlanDesignDTO planDesignDTO);
}
