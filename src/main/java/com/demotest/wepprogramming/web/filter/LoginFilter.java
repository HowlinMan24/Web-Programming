package com.demotest.wepprogramming.web.filter;

import com.demotest.wepprogramming.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(filterName = "authFilter", urlPatterns = "/",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE},
        initParams = {
                @WebInitParam(name = "ignore-path", value = "/login"),
                @WebInitParam(name = "register-path", value = "/register")
        })
public class LoginFilter implements Filter {

    private String ignorePath;
    private String registerPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        this.ignorePath = filterConfig.getInitParameter("ignore-path");
        this.registerPath = filterConfig.getInitParameter("register-path");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("user");
        String path = request.getRequestURI();

        if (path.startsWith(ignorePath) || path.startsWith(registerPath) || user == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
