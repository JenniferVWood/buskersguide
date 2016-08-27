package com.davewhoyt.bg.spring;

import com.davewhoyt.bg.data.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

public class SecurityUtils {
    public static boolean hasRole(String role) {
        @SuppressWarnings("unchecked")
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }


    public static Collection<GrantedAuthority> listRoles() {

        @SuppressWarnings("unchecked")
        Collection<GrantedAuthority> ret =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return  ret;
    }


    public static void logInUser(User user) {
        Authentication auth =
                new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(user.getUserName(), "", getAuthorities()), null, getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);
    }


    private static Collection<GrantedAuthority> getAuthorities() {
        //make everyone ROLE_USER
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            //anonymous inner type
            public String getAuthority() {
                return "ROLE_USER";
            }
        };
        grantedAuthorities.add(grantedAuthority);
        return grantedAuthorities;
    }
}
