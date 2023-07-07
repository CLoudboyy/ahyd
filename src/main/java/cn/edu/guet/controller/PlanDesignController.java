package cn.edu.guet.controller;

import cn.edu.guet.bean.PlanDesignDTO;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.PlanDesignInfoService;
import cn.edu.guet.util.TransactionHandler;
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
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


/**
 * @Author huangzhouyu
 * @Data 2023/5/26 21:45
 */
@Controller
public class PlanDesignController {

    public static Logger logger = LoggerFactory.getLogger(PlanDesignController.class);

    TransactionHandler transactionHandler = new TransactionHandler();

    private PlanDesignInfoService planDesignInfoService;

    public void setPlanDesignInfoService(PlanDesignInfoService planDesignInfoService) {
        this.planDesignInfoService = (PlanDesignInfoService) transactionHandler.createProxyObject(planDesignInfoService);
    }


    /**
     * 业务同路由查询
     * @param id
     * @return
     */
    @RequestMapping("/selectBusinessRouteByPlanDesignId")
    public ResponseData selectBusinessRouteByPlanDesignId(Long id) {
        System.out.println("plan_design_id: " + id);
        return planDesignInfoService.selectBusinessRouteByPlanDesignId(id);
    }

    /**
     * 主同路由查询
     * @param id
     * @return
     */
    @RequestMapping("/selectRouteCableList")
    public ResponseData selectRouteCableList(Long id) {
        return planDesignInfoService.selectRouteCableList(id);
    }

    /**
     * 创建工单号
     *
     * @param planDesignInfo
     * @return
     */
    @RequestMapping("/createBill")
    public ResponseData createBill(PlanDesignInfo planDesignInfo){
        return planDesignInfoService.createBill(planDesignInfo);
    }

    @RequestMapping("/parseCAD")
    public ResponseData parseCAD() {
        return planDesignInfoService.parseCAD();
    }

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

    /**
     * 获取工单号
     */
    @RequestMapping("/getBillNo")
    public ResponseData getBillNo(PlanDesignInfo planDesignInfo) {
        return ResponseData.ok(planDesignInfoService.getBillNo());
    }


    /**
     * 保存并分析
     * @param planDesignInfo
     * @return
     */
    @RequestMapping("/createBillAndAnalyse")
    public ResponseData createBillAndAnalyse(PlanDesignInfo planDesignInfo) {
        logger.info("创建工单：{}", planDesignInfo);
        return planDesignInfoService.createBillAndAnalyse(planDesignInfo);
    }

    @RequestMapping("/searchBill")
    public ResponseData searchBill(PlanDesignDTO planDesignDTO) {
        return planDesignInfoService.searchBill(planDesignDTO);
    }

}
