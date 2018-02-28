package com.tiza.support.filter;

import com.tiza.support.util.JacksonUtil;
import com.tiza.support.util.RedisUtil;
import com.tiza.web.model.RespResult;
import com.tiza.web.model.Token;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Description: TokenAuthorizationFilter
 * Author: DIYILIU
 * Update: 2018-02-27 10:23
 */

@Component
public class TokenAuthorizationFilter implements Filter {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();

        // 请求token
        if (uri.endsWith("query_token")){

            chain.doFilter(request, response);
            return;
        }

        String auth = req.getHeader("Authorization");
        String operatorId = null;
        String[] authArr = auth.split(" ");
        if (authArr.length == 2 && authArr[0].equals("Bearer")) {
            RespResult result = new RespResult();

            String token = authArr[1];
            Token t = (Token) redisUtil.get(token);
            // token 无效
            if (t == null) {
                result.setRet(4002);
                result.setMsg("Token 无效");

                interrupt(response, result);
                return;
            } else {
                // token 过期
                long datetime = t.getDatetime();
                if (System.currentTimeMillis() - datetime > t.getTokenAvailableTime() * 1000) {
                    result.setRet(4002);
                    result.setMsg("Token 过期");

                    interrupt(response, result);
                    return;
                }
            }

            operatorId = t.getOperatorId();
        }

        request.setAttribute("operatorId", operatorId);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 返回错误
     * @param response
     */
    private void interrupt(ServletResponse response,  RespResult result) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON.getType());

        String error = JacksonUtil.toJson(result);
        response.getWriter().write(error);
    }
}
