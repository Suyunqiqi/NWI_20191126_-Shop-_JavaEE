package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Dispatcher",urlPatterns = {"*.action"})
public class Dispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("主控制器");
        String uri=getReqtype(request.getRequestURI());

        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();
        System.out.println(getReqtype("uri--------------"+request.getRequestURI()));
        if (uri.equals("login.action")){
            System.out.println("主控制器分发---------用户登录");
            ModelAndView modelAndView=new UserController().login(request,response,session);
            System.out.println(JSON.toJSONString(modelAndView));
            out.println(JSON.toJSONString(modelAndView));
        }else if (uri.equals("queryAll.action")){
            System.out.println("主控制器分发---------查询商品");
            ModelAndView modelAndView=new ProdunctController().queryTopPro(request,response,session);
            System.out.println(JSON.toJSONString(modelAndView));
            out.println(JSON.toJSONString(modelAndView));
        }else if (uri.equals("addToCart.action")){
            System.out.println("主控制器分发---------加入购物车");
            ModelAndView modelAndView=new CartListController().addToCart(request,response,session);
            System.out.println(JSON.toJSONString(modelAndView));
            out.println(JSON.toJSONString(modelAndView));

        }else {
            out.println("来自中央控制器，路径错误");
            System.out.println("来自中央控制器，路径错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    /*
        截取请求路径得到纯净的*.action
         */
    protected String getReqtype(String uri){
        String[] uris=uri.split("/");
        for(String u:uris){
            if (u.contains(".action")){
                return u;
            }
        }
        return "";
    }
}