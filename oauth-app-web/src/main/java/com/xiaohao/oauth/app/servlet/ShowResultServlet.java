package com.xiaohao.oauth.app.servlet;

import com.tencent.weibo.api.TAPI;
import com.tencent.weibo.oauthv2.OAuthV2;
import com.xiaohao.oauth.app.Constant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaohao on 2014/9/23.
 */
public class ShowResultServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OAuthV2 oAuthV2 =(OAuthV2)req.getSession().getAttribute("oauth");
        TAPI tAPI = new TAPI(oAuthV2.getOauthVersion());//根据oAuth配置对应的连接管理器
        //取得返回结果
        String response = null;
        try{
            response= tAPI.add(oAuthV2, Constant.format, "经过系统测算你上辈子是王二小~ 哈哈", Constant.clientip, Constant.jing, Constant.wei, Constant.syncflag);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("send content:"+response);
        req.getRequestDispatcher("/gameOver.jsp").forward(req,resp);
    }
}
