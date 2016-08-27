package com.davewhoyt.bg.spring;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * This class exists because there's no simple way to include SpringSecurity Taglibs in FreeMarker templates.
 */
@Component
public class PrincipalInjectingHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);

        if (modelAndView != null) {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication a = ctx.getAuthentication();

            Object p;
            if (isAnonymous(a)) {
             p = new AnonymousUser();
            } else {
                p = a.getPrincipal();
            }
            modelAndView.addObject("principal", p);
        }
    }


    private boolean isAnonymous(Authentication a) {
        if (a == null) return true;
        for (GrantedAuthority ga : a.getAuthorities()) {
            if (ga.getAuthority().equalsIgnoreCase("ROLE_ANONYMOUS"))
                return true;
        }
        return false;
    }

}
