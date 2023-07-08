package cn.edu.guet.controller;

import cn.edu.guet.bean.PlanDesignDTO;
import cn.edu.guet.bean.PlanDesignInfo;
import cn.edu.guet.common.ResponseData;
import cn.edu.guet.service.PlanDesignInfoService;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;
import java.util.List;


/**
 * @Author huangzhouyu
 * @Data 2023/5/26 21:45
 */
@Controller
public class PlanDesignController {

    public static Logger logger = LoggerFactory.getLogger(PlanDesignController.class);

    @Autowired
    private PlanDesignInfoService planDesignInfoService;


    /**
     * 业务同路由查询
     * @param id
     * @return
     */
    @RequestMapping("/selectBusinessRouteByPlanDesignId.do")
    @ResponseBody
    public ResponseData selectBusinessRouteByPlanDesignId(Long id) {
        System.out.println("plan_design_id: " + id);
        return planDesignInfoService.selectBusinessRouteByPlanDesignId(id);
    }

    /**
     * 主同路由查询
     * @param id
     * @return
     */
    @RequestMapping("/selectRouteCableList.do")
    @ResponseBody
    public ResponseData selectRouteCableList(Long id) {
        return planDesignInfoService.selectRouteCableList(id);
    }

    /**
     * 创建工单号
     *
     * @param planDesignInfo
     * @return
     */
    @RequestMapping("/createBill.do")
    @ResponseBody
    public ResponseData createBill(@RequestBody PlanDesignInfo planDesignInfo){
        return planDesignInfoService.createBill(planDesignInfo);
    }

    @RequestMapping("/parseCAD.do")
    @ResponseBody
    public ResponseData parseCAD() {
        return planDesignInfoService.parseCAD();
    }

    @RequestMapping("/upload.do")
    @ResponseBody
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
    @RequestMapping("/getBillNo.do")
    @ResponseBody
    public ResponseData getBillNo() {
        return ResponseData.ok(planDesignInfoService.getBillNo());
    }


    /**
     * 保存并分析
     * @param planDesignInfo
     * @return
     */
    @RequestMapping("/createBillAndAnalyse.do")
    @ResponseBody
    public ResponseData createBillAndAnalyse(@RequestBody PlanDesignInfo planDesignInfo) {
        logger.info("创建工单：{}", planDesignInfo);
        return planDesignInfoService.createBillAndAnalyse(planDesignInfo);
    }

    @RequestMapping("/searchBill.do")
    @ResponseBody
    public ResponseData searchBill(@RequestBody PlanDesignDTO planDesignDTO) {
        return planDesignInfoService.searchBill(planDesignDTO);
    }

}
