package com.anzhi.jwt;


import com.anzhi.common.properties.FebsProperties;
import com.anzhi.common.utils.FebsUtil;
import com.anzhi.common.utils.SpringContextUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 写一个jwt过滤器来作为shiro的过滤器
 * @author admin
 *
 */

@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private static final String TOKEN = "token";

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        FebsProperties febsProperties = SpringContextUtil.getBean(FebsProperties.class);
//        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(febsProperties.getShiro().getAnonUrl(), StringPool.COMMA);
//        boolean match = false;
//        for (String u : anonUrl) {
//        	System.out.println("JWFilter" + u);
//            if (pathMatcher.match(u, httpServletRequest.getRequestURI()))
//                match = true;
//        }
//        if (match) return true;
//        if (isLoginAttempt(request, response)) {
//            return executeLogin(request, response);
//        }
//        return false;
    	
    	//判断请求的请求头是否带上 "Token"
        if (isLoginAttempt(request, response)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
            	System.out.println("lalalllllllllllllllll");
                executeLogin(request, response);
                return true;
            } catch (Exception e) {           	
                //token 错误
                responseError(response, e.getMessage());
            }
        }
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(TOKEN);
        return token != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN);
        System.out.println("JWFilter" + token);
        JWTToken jwtToken = new JWTToken(FebsUtil.decryptToken(token));
        System.out.println("JWTToken" + jwtToken.toString());
        try {
            getSubject(request, response).login(jwtToken);
            return true;
        } catch (Exception e) {
        	System.out.println("JWTFilter错误");
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个 option请求，这里我们给 option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
    
    
    /**
     * 将非法请求跳转到 /unauthorized/**
     */
    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/unauthorized/" + message);
        } catch (IOException e) {
            logger.error("非法请求"+e.getMessage());
        }
    }
}
