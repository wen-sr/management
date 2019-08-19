package com.management.vo.xhwl;

import com.management.pojo.jc.ChanLiang;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/12 11:23
 * Modified By：
 */
public class XHWLMessageWxVo {

    private String shouhuo;

    private String chuhuo;

    private List<ChanLiang> jiaocai;

    public String getShouhuo() {
        return shouhuo;
    }

    public void setShouhuo(String shouhuo) {
        this.shouhuo = shouhuo;
    }

    public String getChuhuo() {
        return chuhuo;
    }

    public void setChuhuo(String chuhuo) {
        this.chuhuo = chuhuo;
    }

    public List<ChanLiang> getJiaocai() {
        return jiaocai;
    }

    public void setJiaocai(List<ChanLiang> jiaocai) {
        this.jiaocai = jiaocai;
    }
}
