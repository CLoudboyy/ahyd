package cn.edu.guet.controller;

import cn.edu.guet.bean.PlanDesignHistoryRecord;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.PlanDesignService;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author huangzhouyu
 * @Data 2023/5/26 21:45
 */
@Controller
public class PlanDesignController {

    public static Logger logger = LoggerFactory.getLogger(PlanDesignInfo.class);

    private PlanDesignService planDesignService;

    public void setPlanDesignService(PlanDesignService planDesignService) {
        this.planDesignService = planDesignService;
    }

    /**
     * 查询主备路由光缆
     *
     * @return JSON数据
     */
    @RequestMapping("/selectRouteCableList")
    public ResponseData selectRouteCableList() {
        return planDesignService.selectRouteList();
    }

    /**
     * 创建工单号
     *
     * @param planDesignInfo
     * @return
     */
    @RequestMapping("/createBill")
    public ResponseData createBill(PlanDesignInfo planDesignInfo) {
        logger.info("创建工单：{}", planDesignInfo);
        return planDesignService.createBill(planDesignInfo);
    }

    /**
     * 获取工单号
     */
    @RequestMapping("/getBillNo")
    public ResponseData getBillNo(PlanDesignInfo planDesignInfo) {
        return ResponseData.ok(planDesignService.getBillNo());
    }

    /**
     * 工单号获取
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/upload")
    public ResponseData upload(HttpServletRequest request, HttpServletResponse response) {
        String dir = System.getProperty("user.dir");
        dir = dir.substring(0, dir.lastIndexOf("\\"));
        Gson gson = new Gson();
        String realPath = dir + "\\webapps\\upload";
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart == true) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator<FileItem> itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (!item.isFormField()) {
                    File fullFile = new File(item.getName());
                    File savedFile = new File(realPath + "/", fullFile.getName());
                    try {
                        item.write(savedFile);
                        String url = "http://localhost:8080/upload/" + fullFile.getName();
                        String[] strs = {url};
                        return ResponseData.ok(strs);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.print("the enctype must be multipart/form-data");
        }
        return null;
    }

    @RequestMapping("/createBillAndAnalyse")
    public ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo) {
        /*
        1、保存工单
        2、调用解析接口
         */
        planDesignService.createBill(planDesignInfo);
        planDesignInfo.setReviewer("桂电");
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
        HttpResponse response = HttpRequest.post("http://1.116.118.200:9999/analysCADCallApi")
                .headerMap(heads, false)
                .body(queryJson)
                .timeout(5*60*100)
                .execute();
        ResponseData responseData=new Gson().fromJson(response.body(),ResponseData.class);
        logger.info(responseData.getCode() + "");
        logger.info(responseData.getMessage());
        logger.info(responseData.getData() + "");
        Map<String, Object> dataMap = (Map<String, Object>) responseData.getData();
        String analyseNo = (String) dataMap.get("analyseNo");
        String planBillNo = (String) dataMap.get("planBillNo");
        return responseData;
    }
}
