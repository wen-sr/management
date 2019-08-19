package com.management.service.xhwl.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.aspect.HttpAspect;
import com.management.common.EasyuiTableResponse;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.busi.SendOpenidListMapper;
import com.management.dao.info.InforErrorMapper;
import com.management.dao.prd1.WmsErrorMsgMapper;
import com.management.dao.xhwl.BZChuHuoMapper;
import com.management.pojo.busi.BusiMessageWx;
import com.management.pojo.busi.SendOpenidList;
import com.management.pojo.jc.ChanLiang;
import com.management.pojo.jxlh56.News;
import com.management.pojo.xhwl.BZChuHuo;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.service.xhwl.IBZChuHuoService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.xhwl.XHWLMessageWxVo;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/12 10:36
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_xh",readOnly = false)
public class BZChuHuoServiceimpl implements IBZChuHuoService {

    private final static Logger logger = LoggerFactory.getLogger(BZChuHuoServiceimpl.class);


    @Autowired
    BZChuHuoMapper bzChuHuoMapper;

    @Autowired
    SendOpenidListMapper sendOpenidListMapper;

    @Autowired
    WxMpService wxMpService;

    @Autowired
    ILogisticsQueryService logisticsQueryService;

    @Autowired
    WmsErrorMsgMapper wmsErrorMsgMapper;

    @Autowired
    InforErrorMapper inforErrorMapper;


    @Override
    public EasyuiTableResponse loadData(Integer pageSize, Integer pageNum, BZChuHuo bzChuHuo) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);

        PageHelper.startPage(pageNum,pageSize);
        List<BZChuHuo> bzChuHuoList = bzChuHuoMapper.findAll(bzChuHuo);
        PageInfo pageInfo = new PageInfo(bzChuHuoList);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setRows(pageInfo.getList());
        response.setCode(0);
        response.setCount(bzChuHuoList.size());
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    @Override
    public ServerResponse addInfo(BZChuHuo bzChuHuo) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<BZChuHuo> bzChuHuoList = bzChuHuoMapper.findAll(bzChuHuo);
        if(bzChuHuoList != null && bzChuHuoList.size() > 0 ){
            return ServerResponse.createByErrorMessage("您已经添加过，请勿重复添加");
        }

        bzChuHuo.setAddwho(RequestHolder.getCurrentUser().getName());
        bzChuHuoMapper.insertSelective(bzChuHuo);
        SendWx();
        return ServerResponse.createBySuccessMsg("添加成功");
    }

    @Override
    public void SendWx() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        //收货
        Integer shouhuo = logisticsQueryService.ReceiptQty();
        //出货
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        Integer chuhuo = inforErrorMapper.getChuHuoQty();
        //教材
        List<ChanLiang> jiaocai = wmsErrorMsgMapper.getJiaoCaiChanLiang();
        XHWLMessageWxVo xhwlMessageWx = new XHWLMessageWxVo();
        xhwlMessageWx.setShouhuo(shouhuo == null ? "0" :shouhuo.toString());
        xhwlMessageWx.setChuhuo(chuhuo == null ? "0" :chuhuo.toString());
        xhwlMessageWx.setJiaocai(jiaocai);
        List<SendOpenidList> sendOpenidList = sendOpenidListMapper.selectByType("xhwl");
        for(SendOpenidList s : sendOpenidList) {
            sendToWechat(xhwlMessageWx, s.getOpenid());
        }
    }

    private void sendToWechat(XHWLMessageWxVo xhwlMessageWx, String openid){
        if(xhwlMessageWx == null ){
            return;
        }
        String shouhuo = xhwlMessageWx.getShouhuo();
        String chuhuo = xhwlMessageWx.getChuhuo();
        List<ChanLiang> jiaocai = xhwlMessageWx.getJiaocai();
        String content = "";
        if( (shouhuo != null && !"0".equals(shouhuo)) || (chuhuo != null && !"0".equals(chuhuo)) || (jiaocai != null && jiaocai.size() > 0)  ){
            content = "新华物流今日工作产量：";
            if((shouhuo != null && !"0".equals(shouhuo))){
                content += "4号库总收货：" + shouhuo + "件";
            }
            if((chuhuo != null && !"0".equals(chuhuo))){
                if(content.length() != 9){
                    content += "；总出货：" + chuhuo + "件";
                }else{
                    content += "总出货：" + chuhuo + "件";
                }
            }
            if(jiaocai != null && jiaocai.size() > 0){
                if(content.length() != 9){
                    content += "；教材：";
                }else{
                    content += "教材：";
                }
                for(ChanLiang c : jiaocai ){
                    content += c.getIssue() + ":" + "至今总出票:" + c.getHeJi() + "件，其中代发" + c.getDaiFa() +"件;总交包：" + c.getJiaobao() + "件;";
                }
            }
        }
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openid)
                .templateId("j3uSiEeYMGG1UrMmU_AZlIJ_xwdTChiCGkKCpbTr2sk").build();
        templateMessage.getData().add(new WxMpTemplateData("first", content, "#FF3333"));
        templateMessage.getData().add(new WxMpTemplateData("keyword1", "新华物流", "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("keyword2", DateTimeUtil.dateToStr(new Date()), "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流科技有限公司", "#AAAAAA"));
        //templateMessage.setUrl("http://www.jxxh56.com/management/page/busi/messageShow.html?id=" + busiMessageWx.getId());
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
            logger.error("=====微信发送系统故障提醒时报错=====",e);
        }
    }
}
