package com.management.util;

import com.management.aspect.HttpAspect;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/4 10:49
 * Modified By：
 */
public class WechatMaterialUtil {

    private final static Logger logger = LoggerFactory.getLogger(WechatMaterialUtil.class);

    public static String getMediaIdFromUrl(WxMpService wxMpService,String urlPath, String fileType) throws Exception {

        InputStream is = getInputStreamByUrl(urlPath);

        WxMediaUploadResult res = wxMpService.getMaterialService().mediaUpload(WxConsts.MediaFileType.IMAGE, fileType, is);
        res.getType();
        res.getCreatedAt();
        res.getMediaId();
        res.getThumbMediaId();
        return res.getMediaId();
    }

    public static InputStream getInputStreamByUrl(String strUrl){
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(),output);
            return  new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            logger.error(e+"");
        }finally {
            try{
                if (conn != null) {
                    conn.disconnect();
                }
            }catch (Exception e){
                logger.error(e+"");
            }
        }
        return null;
    }
}
