package com.xiaohao.oauth.app.servlet;


import com.tencent.weibo.oauthv2.OAuthV2;
import com.tencent.weibo.oauthv2.OAuthV2Client;
import com.xiaohao.oauth.app.helper.OauthHelper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by xiaohao on 2014/9/15.
 */
public class AuthOkServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OAuthV2 oAuth =new OAuthV2();
        String respBody =req.getQueryString();
        OAuthV2Client.parseAuthorization(respBody,oAuth);

       // OAuthV2Client.parseAccessTokenAndOpenId(responseData, oAuth)

        oAuth.setOpenid("");
        oAuth.setAuthorizeCode("");
        oAuth.setOpenkey("");

//        System.out.println("AuthOkServlet");
//
//        String code = req.getParameter(Constants.auth_back_code_param);
//
//        String openid = req.getParameter(Constants.auth_back_openid_param);
//
//        String openKey = req.getParameter(Constants.auth_back_openkey_param);
//
//        System.out.println("code :" + code);
//        System.out.println("openid :" + openid);
//        System.out.println("openkey :" + openKey);
//
//        req.setAttribute("code", code);
//        req.setAttribute("code", code);
//        req.setAttribute("code", code);
//
//        //取得code
//
//        //下面使用httpClient来获取accessToken
//
//
//        HttpClient httpClient = new HttpClient();
//        httpClient.getParams().setContentCharset("UTF-8");
//        HttpMethod method = new PostMethod(Constants.generateAccessTokenUrl(code));
//        int status = httpClient.executeMethod(method);
//        if (status == 200) {
//            String body = method.getResponseBodyAsString();
//            Map<String, String> map = OauthHelper.parseAccessToken(body);
//            if (map != null && map.get("accessToken") != null) {
//                req.getSession().setAttribute("token", map.get("accessToken"));
//                req.getSession().setAttribute("authMap",map);
//                resp.sendRedirect("invalidSession.jsp");
//            }
//        }

    }

}
