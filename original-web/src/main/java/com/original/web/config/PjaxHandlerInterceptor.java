package com.original.web.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PjaxHandlerInterceptor
 *
 * @author luhangqi
 * @date 2018/10/23
 */
public class PjaxHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String isPJAX = request.getHeader("X-PJAX");
        if (isPJAX == null && StringUtils.isEmpty(isPJAX)) {
            String path = request.getServletPath();
            String suffix = path.substring(path.lastIndexOf(".") + 1, path.length());
            //判断是否弹出框请求
            if (!StringUtils.isEmpty(suffix) && suffix.equals("modal")) {
                request.getRequestDispatcher("toIndex");
            } else {
                path = path.substring(0, 1).equals("/") ? path.substring(1) : path;
                //获取地址栏参数
                if (!StringUtils.isEmpty(request.getQueryString())) {
                    path += "?" + request.getQueryString();
                }
                request.setAttribute("INDEX_BACK_URL", path);
                //发回主页 并重新加载内容
                request.getRequestDispatcher("/toIndex").forward(request, response);
            }
            return false;
        }
        return true;
    }
}
