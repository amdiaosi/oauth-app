package com.xiaohao.oauth.app.servlet;


import com.tencent.weibo.api.TAPI;
import com.tencent.weibo.oauthv2.OAuthV2;
import com.tencent.weibo.oauthv2.OAuthV2Client;
import com.tencent.weibo.utils.QHttpClient;
import com.xiaohao.oauth.app.Constant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaohao on 2014/9/15.
 */
public class AuthOkServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuthV2 oAuth =new OAuthV2();

        //自定制http连接管理器
        QHttpClient qHttpClient = new QHttpClient(2, 2, 5000, 5000, null, null);
        OAuthV2Client.setQHttpClient(qHttpClient);
        String queryString =req.getQueryString();
        OAuthV2Client.parseAuthorization(queryString, oAuth);

        //取得queryString 然后解析queryString给OAuthV2对象赋值

        // //换取access token
        oAuth.setGrantType("authorize_code");
        try {
            OAuthV2Client.accessToken(oAuth);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        TAPI tAPI = new TAPI(oAuth.getOauthVersion());//根据oAuth配置对应的连接管理器
        //取得返回结果
        String response = null;
        try{
            tAPI.add(oAuth, Constant.format, "测试发表文字微博" + Constant.content, Constant.clientip, Constant.jing, Constant.wei, Constant.syncflag);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("send content:"+response);
        qHttpClient.shutdownConnection();

        req.getSession().setAttribute("token", "ok");

    }

}
