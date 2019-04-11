package com.management.controller.xhwl;

import com.management.aspect.HttpAspect;
import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.xhwl.JiaoCaiPlanData;
import com.management.service.xhwl.IJiaoCaiPlanDataService;
import com.management.util.ImportExcelUtil;
import com.management.vo.xhwl.JiaoCaiPlanDataVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/8 10:53
 * Modified By：
 */
@RestController
@RequestMapping("/jiaoCaiPlan")
public class JiaoCaiPlanDataController {

    private final static Logger logger = LoggerFactory.getLogger(JiaoCaiPlanDataController.class);

    @Autowired
    IJiaoCaiPlanDataService jiaoCaiPlanDataService;

    @RequestMapping(value = "/uploadDataExcel", method = {RequestMethod.GET, RequestMethod.POST})
    public ServerResponse uploadExcel(HttpServletRequest request) throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        logger.info("通过传统方式form表单提交方式导入excel文件！");

        InputStream in = null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if (file.isEmpty()) {
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        //
        //HSSFWorkbook workbook = new HSSFWorkbook();

        ImportExcelUtil iu = new ImportExcelUtil();

        listob = iu.getBankListByExcel(in, file.getOriginalFilename());


        in.close();

        return jiaoCaiPlanDataService.saveRecords(listob);
    }

    @RequestMapping("/findAll")
    public EasyuiTableResponse findAll(@RequestParam(value = "rows", defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                       JiaoCaiPlanDataVo jiaoCaiPlanDataVo) {
        return jiaoCaiPlanDataService.findAll(jiaoCaiPlanDataVo, pageSize, pageNum);
    }


    @RequestMapping("/issueNumberTips")
    public List<JiaoCaiPlanDataVo> issueNumberTips() {
        return jiaoCaiPlanDataService.issueNumberTips();
    }


    @RequestMapping("/plantingnameTips")
    public List<JiaoCaiPlanDataVo> plantingnameTips() {
        return jiaoCaiPlanDataService.plantingnameTips();
    }



    @RequestMapping("/subcodeTips")
    public List<JiaoCaiPlanDataVo> subcodeTips() {
        return jiaoCaiPlanDataService.subcodeTips();
    }


    @RequestMapping("/typeTips")
    public List<JiaoCaiPlanDataVo> typeTips() {
        return jiaoCaiPlanDataService.typeTips();
    }




}
