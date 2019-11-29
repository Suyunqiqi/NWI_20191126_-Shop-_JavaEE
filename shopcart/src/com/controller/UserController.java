package com.controller;

import com.dao.interf.DaoInterface;
import com.pojo.ModelAndView;
import com.pojo.Sq_user;
import com.pojo.UserPlus;
import com.service.impl.UserServiceImpl;
import com.service.interf.UserServiceInface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController {
    private UserServiceInface userService=new UserServiceImpl();

    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        Sq_user user=new Sq_user();
        user.setUacc(request.getParameter("uacc"));
        user.setUpwd(request.getParameter("upwd"));
        userService.setDao((DaoInterface)request.getServletContext().getAttribute("dao"));
        ModelAndView modelAndView=userService.login(user);
        if (modelAndView.getFlag()=="666") {
            session.setAttribute("uid", ((UserPlus) modelAndView.getObject()).getUid());
            session.setAttribute("cid", ((UserPlus) modelAndView.getObject()).getCid());
        }else{
            modelAndView.getFlag();
        }
        return modelAndView;
    }

}
