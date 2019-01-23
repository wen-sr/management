package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiPackMapper;
import com.management.dao.jc.JiaoCaiSkuMapper;
import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.dao.login.LoginMapper;
import com.management.pojo.jc.JiaoCaiPack;
import com.management.pojo.jc.JiaoCaiSku;
import com.management.pojo.jc.JiaoCaiStorer;
import com.management.pojo.login.Login;
import com.management.service.jc.IJiaoCaiSkuService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.jc.JiaoCaiSkuVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 11:15
 * Modified By：
 */
@Service
@Transactional
public class JiaoCaiSkuServiceImpl implements IJiaoCaiSkuService {

    @Autowired
    JiaoCaiSkuMapper jiaoCaiSkuMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;

    @Autowired
    JiaoCaiPackMapper jiaoCaiPackMapper;

    @Override
    public ServerResponse findAll(Integer pageSize, Integer pageNum, JiaoCaiSkuVo jiaoCaiSku) {

        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<JiaoCaiSku> jiaoCaiSkuList = null;
        PageHelper.startPage(pageNum,pageSize);

        jiaoCaiSkuList = jiaoCaiSkuMapper.findAll(jiaoCaiSku);
        List<JiaoCaiSkuVo> jiaoCaiSkuVoList = parseToJiaoCaiSkuVo(jiaoCaiSkuList);

        PageInfo pageInfo = new PageInfo(jiaoCaiSkuList);
        pageInfo.setList(jiaoCaiSkuVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse add(JiaoCaiSku jiaoCaiSku) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        jiaoCaiSku.setAddwho(RequestHolder.getCurrentUser().getId());
        jiaoCaiSku.setEditwho(RequestHolder.getCurrentUser().getId());
        int i = jiaoCaiSkuMapper.insertSelective(jiaoCaiSku);
        if(i > 0){
            if(jiaoCaiSku.getPack() > 0) {
                JiaoCaiPack jiaoCaiPack = new JiaoCaiPack();
                jiaoCaiPack.setIssuenumber(jiaoCaiSku.getIssuenumber());
                jiaoCaiPack.setSubcode(jiaoCaiSku.getSubcode());
                jiaoCaiPack.setPack(jiaoCaiSku.getPack().intValue());
                jiaoCaiPackMapper.insertSelective(jiaoCaiPack);
            }
            return ServerResponse.createBySuccessMsg("添加资料成功");
        }else {
            return ServerResponse.createByErrorMessage("添加资料失败，请联系管理员");
        }
    }

    @Override
    public ServerResponse update(JiaoCaiSku jiaoCaiSku) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        if(StringUtils.isBlank(jiaoCaiSku.getIssuenumber()) || StringUtils.isBlank(jiaoCaiSku.getSubcode())){
            return ServerResponse.createByErrorMessage("未获得期号和征订代码无法修改资料，请联系管理员");
        }
        jiaoCaiSku.setEditwho(RequestHolder.getCurrentUser().getId());
        int i = jiaoCaiSkuMapper.updateByPrimaryKeySelective(jiaoCaiSku);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("修改成功");
        }else {
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }

    @Override
    public ServerResponse delete(JiaoCaiSku jiaoCaiSku) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        if(StringUtils.isBlank(jiaoCaiSku.getIssuenumber()) || StringUtils.isBlank(jiaoCaiSku.getSubcode())){
            return ServerResponse.createByErrorMessage("未获得期号和征订代码无法删除资料，请联系管理员");
        }
        int i = jiaoCaiSkuMapper.deleteByPrimaryKey(jiaoCaiSku);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("删除成功");
        }else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }


    private List<JiaoCaiSkuVo> parseToJiaoCaiSkuVo(List<JiaoCaiSku> jiaoCaiSkuList) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<JiaoCaiSkuVo> jiaoCaiSkuVoList = new ArrayList<>();
        JiaoCaiSkuVo jiaoCaiSkuVo = null;
        for(JiaoCaiSku d : jiaoCaiSkuList) {
            jiaoCaiSkuVo = new JiaoCaiSkuVo();
            jiaoCaiSkuVo.setAdddate(DateTimeUtil.dateToStr(d.getAdddate()));
            jiaoCaiSkuVo.setEditdate(DateTimeUtil.dateToStr(d.getEditdate()));

            Login user = loginMapper.selectByPrimaryKey(d.getAddwho());
            Login user2 = loginMapper.selectByPrimaryKey(d.getEditwho());

            if(user != null && user.getName() != null){
                jiaoCaiSkuVo.setAddwho(user.getName());
            }
            if(user2 != null && user2.getName() != null){
                jiaoCaiSkuVo.setEditwho(user2.getName());
            }
            jiaoCaiSkuVo.setBarcode(d.getBarcode());
            jiaoCaiSkuVo.setBundle(d.getBundle());
            jiaoCaiSkuVo.setDescr(d.getDescr());
            jiaoCaiSkuVo.setId(d.getId());
            jiaoCaiSkuVo.setPack(d.getPack());
            jiaoCaiSkuVo.setPrice(d.getPrice());
            jiaoCaiSkuVo.setPublisher(d.getPublisher());

            JiaoCaiStorer jiaoCaiStorer = jiaoCaiStorerMapper.selectByStorerKey(d.getPublisher());
            jiaoCaiSkuVo.setShortname(jiaoCaiStorer.getShortname());

            jiaoCaiSkuVo.setIssuenumber(d.getIssuenumber());
            jiaoCaiSkuVo.setSubcode(d.getSubcode());
            jiaoCaiSkuVoList.add(jiaoCaiSkuVo);
        }

        return jiaoCaiSkuVoList;
    }
}
