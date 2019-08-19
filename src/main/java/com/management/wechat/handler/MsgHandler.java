package com.management.wechat.handler;

import com.management.dao.login.LoginMapper;
import com.management.dao.wechat.UserInfoMapper;
import com.management.pojo.wcs.StockMiniload;
import com.management.pojo.wcs.TaskCar;
import com.management.pojo.wcs.TaskOps;
import com.management.pojo.wcs.TaskWms;
import com.management.pojo.wechat.UserInfo;
import com.management.service.wcs.IStockMiniloadService;
import com.management.service.wcs.ITaskCarService;
import com.management.service.wcs.ITaskOpsService;
import com.management.service.wcs.ITaskWmsService;
import com.management.service.wechat.WeixinService;
import com.management.service.xhwl.IBZChuHuoService;
import com.management.util.ApacheHttpUtils;
import com.management.vo.login.UserVo;
import com.management.wechat.builder.TextBuilder;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class MsgHandler extends AbstractHandler {
    private final static Logger logger = LoggerFactory.getLogger(MsgHandler.class);

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    IStockMiniloadService stockMiniloadService;

    @Autowired
    ITaskWmsService taskWmsService;

    @Autowired
    ITaskOpsService taskOpsService;

    @Autowired
    ITaskCarService taskCarService;

    @Autowired
    IBZChuHuoService bzChuHuoService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
      Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager)    {

        logger.info("%%%收到微信消息"+ wxMessage.getContent() +"%%%,开始处理：");

        WeixinService   weixinService = (WeixinService) wxMpService;
        //组装回复消息
        String content = "";
        if (!wxMessage.getMsgType().equals(WxConsts.XmlMsgType.EVENT)) {
            //可以选择将消息保存到本地
            if(wxMessage.getContent().contains("@")){
                logger.info("%%%开始处理绑定工号");
                content = "绑定工号中。。。";
                String[] strArray = wxMessage.getContent().split("@");
                if(strArray.length != 2 || "".equals(strArray[0]) || "".equals(strArray[1]) || "LH".equals(strArray[0].subSequence(0, 1))) {
                    content = "您绑定工号的格式不对";
                }else{
                    UserInfo userInfo = userInfoMapper.selectByOpenId(wxMessage.getFromUser());
                    if(userInfo != null){
                        if(userInfo.getLoginId() != null && "".equals(userInfo.getLoginId())){
                            content = "您好,您已经绑定工号【" + userInfo.getLoginId() + "】,无需再次绑定";
                        }else{
                            userInfo = userInfoMapper.selectByLoginId(strArray[0].toUpperCase());
                            if(userInfo != null){
                                content = "您好,您的工号已经绑定了一个微信,无法再次绑定";
                            }
                            //验证工号和姓名是否匹配
                            UserVo userVo = loginMapper.selectUserAndOrgnazizationById(strArray[0].toUpperCase());
                            if(userVo == null || !StringUtils.equals(userVo.getName(), strArray[1])){
                                String con = "";
                                if(userVo == null){
                                    con = "您所输入的工号不存在";
                                }else{
                                    con = "您所输入的工号与姓名不符";
                                }
                                WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                                        .toUser(wxMessage.getFromUser())
                                        .templateId("TikJ2xrlkEXAzx-hBmZZbjfV9HHeOaaPy3vq4jdRpCI").build();
                                templateMessage.getData().add(new WxMpTemplateData("first", "您好,绑定工号失败！", "#284177"));
                                templateMessage.getData().add(new WxMpTemplateData("keyword1", wxMessage.getContent(), "#0044BB"));
                                templateMessage.getData().add(new WxMpTemplateData("keyword2", con, "#0044BB"));
                                templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流技术部", "#AAAAAA"));
                                try {
                                    wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
                                    return null;
                                } catch (WxErrorException e) {
                                    e.printStackTrace();
                                }
                            }
                            userInfo.setLoginId(strArray[0].toUpperCase());
                            int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
                            if(i > 0) {
                                WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                                        .toUser(wxMessage.getFromUser())
                                        .templateId("DYzLbq8MOWCimVg5MG2-qtmdm5RX7MqF2gAvwE9sIuQ").build();
                                templateMessage.getData().add(new WxMpTemplateData("first", "恭喜您,工号和微信账号绑定成功！", "#284177"));
                                templateMessage.getData().add(new WxMpTemplateData("keyword1", userInfo.getNickname(), "#0044BB"));
                                templateMessage.getData().add(new WxMpTemplateData("keyword2", userVo.getName(), "#0044BB"));
                                templateMessage.getData().add(new WxMpTemplateData("keyword3", "江西蓝海物流" + userVo.getOrganizationName(), "#0044BB"));
                                templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流技术部", "#AAAAAA"));
                                try {
                                    wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
                                    return null;
                                } catch (WxErrorException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }else{
                        content = "您好,绑定工号出错,请您重新关注,再重新绑定工号";
                    }

            }
        }

        }

        //当用户输入关键词如“你好”,“客服”等,并且有客服在线时,把消息转发给在线客服
        if (StringUtils.startsWithAny(wxMessage.getContent(), "发送产量", "新华物流产量", "产量", "发产量")) {
            bzChuHuoService.SendWx();
            //ApacheHttpUtils.sendHttpPost("http://141.168.1.188:8080/jxxhwl/wx/wXFunction_sendChanLiang.action");
        }
        if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
            && weixinService.hasKefuOnline()) {
            return WxMpXmlOutMessage
                .TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser())
                .toUser(wxMessage.getFromUser()).build();
        }

        if (StringUtils.startsWithAny(wxMessage.getContent(), "B", "b")) {
            logger.info("%%%开始处理箱号任务查询");
            //小车任务
            String car = "";
            List<TaskCar> taskCarList = taskCarService.selectByContainerCode(wxMessage.getContent().substring(1));
            if(taskCarList != null && taskCarList.size() > 0){
                car = "【小车任务消息】:";
                for(TaskCar taskCar : taskCarList){
                    String taskType = taskCar.getTaskType();
                    if("SIBT".equalsIgnoreCase(taskType)){
                        taskCar.setTaskType("入库任务");
                    }else if("SOBT".equalsIgnoreCase(taskType)){
                        taskCar.setTaskType("出库任务");
                    }else if("SART".equalsIgnoreCase(taskType)){
                        taskCar.setTaskType("借道任务");
                    }else if("SMOT".equalsIgnoreCase(taskType)){
                        taskCar.setTaskType("移库任务");
                    }else {
                        taskCar.setTaskType("其他");
                    }
                    car += ("任务类型:" + taskCar.getTaskType() +
                            ",状态:" + taskCar.getStatus() +
                            ",立库返回值:" + taskCar.getRet());
                }
                car += ";";
            }
            //查询WMS任务
            String wms = "";
            List<TaskWms> taskWmsList = taskWmsService.selectByConnbr(wxMessage.getContent().toUpperCase());
            if(taskWmsList != null && taskWmsList.size()>0){
                wms = "【WMS任务消息】:";
                for(TaskWms taskWms : taskWmsList){
                    wms += (taskWms.getMark() + ",状态:" + taskWms.getStatus());
                }
                wms += ";";
            }
            //查询OPS任务
            String ops = "";
            List<TaskOps> taskOpsList = taskOpsService.selectByConnbr(wxMessage.getContent().toUpperCase());
            if(taskOpsList != null && taskOpsList.size()>0){
                ops = "【OPS任务消息】:";
                for(TaskOps taskOps : taskOpsList){
                    String type = taskOps.getTaskType();
                    if("1".equalsIgnoreCase(type)){
                        taskOps.setMark("提取任务");
                    }else if("2".equalsIgnoreCase(type)){
                        taskOps.setMark("存储任务");
                    }else if("3".equalsIgnoreCase(type)){
                        taskOps.setMark("输送任务");
                    }else if("4".equalsIgnoreCase(type)){
                        taskOps.setMark("注入空箱");
                    }else {
                        taskOps.setMark("其他");
                    }
                    ops += (taskOps.getMark() + ",状态:" + taskOps.getStatus());
                }
                ops += ";";
            }

            StockMiniload stockMiniload = stockMiniloadService.selectByBoxno(wxMessage.getContent());
            if(stockMiniload == null) {
                content = "【" + wxMessage.getContent() + "】该箱号未分配储位;" + car + wms + ops;
                return new TextBuilder().build(content, wxMessage, weixinService);
            }

            if(StringUtils.isBlank(stockMiniload.getContainerCode())){
                content = "您要查询箱号【" + wxMessage.getContent() + "】尚未到位,分配的储位是:"+
                        stockMiniload.getBankId() +"号立库"+ stockMiniload.getBankLayer() +"层"+
                        stockMiniload.getBankColumn() + ";" + car + wms + ops;
                return new TextBuilder().build(content, wxMessage, weixinService);
            }
            if(StringUtils.isNotBlank(stockMiniload.getContainerCode())){
                content = "您要查询箱号【" + wxMessage.getContent() + "】已到位,分配的储位是:"+
                        stockMiniload.getBankId() +"号立库"+ stockMiniload.getBankLayer() +"层"+
                        stockMiniload.getBankColumn() + ";" + car + wms + ops;
                return new TextBuilder().build(content, wxMessage, weixinService);
            }
        }

        return new TextBuilder().build(content, wxMessage, weixinService);

    }

}
