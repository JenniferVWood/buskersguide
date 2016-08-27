package com.davewhoyt.bg.spring;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;

@Component
public class PrincipalInjectingHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        if (modelAndView != null) {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication a = ctx.getAuthentication();
            Object p = a.getPrincipal();
            modelAndView.addObject("principal", p);
        }
    }

}
