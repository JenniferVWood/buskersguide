package com.davewhoyt.bg.spring;

import java.security.Principal;

/**
 * Created by david on 8/27/16.
 */
public class AnonymousUser implements Principal {
    private final String username = "anonymous";
    @Override
    public String getName() {
        return username;
    }
    public String getUsername() {
        return username;
    }
}
