package com.management.controller.wechat;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/wechat/menu"})
public class WxMenuController {
    @Autowired
    private WxMpService wxService;

    public WxMenuController() {
    }

    @GetMapping({"/create"})
    public String menuCreate(@RequestBody WxMenu menu) throws WxErrorException {
        return this.wxService.getMenuService().menuCreate(menu);
    }

    @PostMapping({"/create"})
    public String menuCreateSample() throws WxErrorException {
        WxMenu menu = new WxMenu();
        WxMenuButton menuButton1 = new WxMenuButton();
        menuButton1.setName("客户通道");
        menuButton1.setType("view");
        menuButton1.setUrl("http://www.jxlh56.com/management/page/wechat/customerIndex.html");

        WxMenuButton menuButton2 = new WxMenuButton();
        menuButton2.setName("员工通道");
        menuButton2.setType("view");
        menuButton2.setUrl("http://www.jxlh56.com/management/page/wechat/staffIndex.html");

        WxMenuButton menuButton3 = new WxMenuButton();
        menuButton3.setName("联系我们");
        WxMenuButton lx = new WxMenuButton();
        lx.setName("关于新华物流");
        lx.setType("view");
        lx.setUrl("http://www.jx56.com/jxxhwl/index_layui.html");
        WxMenuButton lx2 = new WxMenuButton();
        lx2.setName("园区信息");
        lx2.setType("view");
        lx2.setUrl("http://www.jx56.com/jx56/Weixin/business/business_park_list.jsp");
        WxMenuButton lx3 = new WxMenuButton();
        lx3.setName("我的工资");
        lx3.setType("view");
        lx3.setUrl("http://www.jxlh56.com/management/oa/wechat/auth?returnUrl=/page/lhwl/performanceWeChat.html");
        WxMenuButton lx1 = new WxMenuButton();
        lx1.setName("工号绑定");
        lx1.setType("click");
        lx1.setKey("jobNumberBinding");
        WxMenuButton lx4 = new WxMenuButton();
        lx4.setName("意见反馈");
        lx4.setType("view");
        lx4.setUrl("http://www.jx56.com/jxxhwl/wx/advice.controller");
        menuButton3.getSubButtons().add(lx);
        menuButton3.getSubButtons().add(lx1);
        menuButton3.getSubButtons().add(lx2);
        menuButton3.getSubButtons().add(lx3);
        menuButton3.getSubButtons().add(lx4);
        menu.getButtons().add(menuButton1);
        menu.getButtons().add(menuButton2);
        menu.getButtons().add(menuButton3);
        return this.wxService.getMenuService().menuCreate(menu);
    }

    @RequestMapping({"/create/{json}"})
    public String menuCreate(@PathVariable String json) throws WxErrorException {
        return this.wxService.getMenuService().menuCreate(json);
    }

    @RequestMapping({"/delete"})
    public void menuDelete() throws WxErrorException {
        this.wxService.getMenuService().menuDelete();
    }

    @RequestMapping({"/delete/{menuId}"})
    public void menuDelete(@PathVariable String menuId) throws WxErrorException {
        this.wxService.getMenuService().menuDelete(menuId);
    }

    @RequestMapping({"/get"})
    public WxMpMenu menuGet() throws WxErrorException {
        return this.wxService.getMenuService().menuGet();
    }

    @RequestMapping({"/menuTryMatch/{userid}"})
    public WxMenu menuTryMatch(@PathVariable String userid) throws WxErrorException {
        return this.wxService.getMenuService().menuTryMatch(userid);
    }

    @RequestMapping({"/getSelfMenuInfo"})
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() throws WxErrorException {
        return this.wxService.getMenuService().getSelfMenuInfo();
    }
}
