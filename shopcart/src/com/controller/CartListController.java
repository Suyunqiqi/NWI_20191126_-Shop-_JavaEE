package com.controller;

import com.dao.interf.DaoInterface;
import com.pojo.CartList;
import com.pojo.ModelAndView;
import com.service.impl.CartListService;
import com.service.interf.CartListServiceInterface;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartListController {
    CartListServiceInterface cartListServiceInterface=new CartListService();
    public ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response,HttpSession session){
        cartListServiceInterface.setDao((DaoInterface)request.getServletContext().getAttribute("dao"));
        CartList cartList=new CartList();
        cartList.setNum(1);
        //cartList.setCid(Integer.parseInt(request.getAttribute("cid".toString())));
        cartList.setCid(1);
        cartList.setPid(Integer.parseInt(request.getParameter("pid")));
        return cartListServiceInterface.addToCart(cartList);
    }
}
