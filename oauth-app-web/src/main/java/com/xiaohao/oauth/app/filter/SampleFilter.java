package com.xiaohao.oauth.app.filter;

import com.tencent.weibo.oauthv2.OAuthV2;
import com.tencent.weibo.oauthv2.OAuthV2Client;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaohao on 2014/9/15.
 */
public class SampleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request =(HttpServletRequest)servletRequest;
        int index =request.getRequestURL().toString().indexOf("auth.do");
        if(index>0){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            String token =(String)request.getSession().getAttribute("token");
            if(token!=null&&!token.equals("")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                HttpServletResponse response =(HttpServletResponse) servletResponse;
                OAuthV2 oAuthV2 =new OAuthV2();
                response.sendRedirect(OAuthV2Client.generateAuthorizationURL(oAuthV2));
            }
        }

    }

    @Override
    public void destroy() {

    }
}
