package com.News.implement;

import com.News.Service.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginServiceImp implements LoginService{
    @Override
    public boolean doLogin(HttpServletRequest httpServletRequest) {

        return false;
    }

    @Override
    public boolean doLogout(HttpServletRequest httpServletRequest) {

        return false;
    }
}
