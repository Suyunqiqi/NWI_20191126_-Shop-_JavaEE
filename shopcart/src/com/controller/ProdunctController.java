package com.controller;

import com.dao.interf.DaoInterface;
import com.pojo.ModelAndView;
import com.service.impl.ProductServiceImpl;
import com.service.interf.ProductServiceInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProdunctController {
    private ProductServiceInterface productServiceInterface=new ProductServiceImpl();
    public ModelAndView queryTopPro(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        productServiceInterface.setDao((DaoInterface)request.getServletContext().getAttribute("dao"));
        return productServiceInterface.querryAllPro();
    }
}
