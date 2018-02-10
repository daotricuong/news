package com.News.Service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    public boolean doLogin(HttpServletRequest httpServletRequest);
    public boolean doLogout(HttpServletRequest httpServletRequest);

}
