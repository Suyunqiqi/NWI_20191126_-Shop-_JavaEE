package com.service.impl;

import com.dao.impl.DaoImpl;
import com.dao.interf.DaoInterface;
import com.pojo.CartList;
import com.pojo.ModelAndView;
import com.service.interf.CartListServiceInterface;

public class CartListService implements CartListServiceInterface {
    private DaoInterface dao=new DaoImpl();
    @Override
    public ModelAndView addToCart(CartList cartList) {
        String sql="insert into cartlist(cid,pid,num)values(?,?,?)";
        ModelAndView modelAndView=new ModelAndView();
        try {
            dao.createPtmt(sql,cartList.getCid(),cartList.getPid(),cartList.getNum());
            int line=dao.update();
            modelAndView.setFlag("666");
            modelAndView.setObject(line);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setFlag("101");
        }
        return modelAndView;
    }

    @Override
    public ModelAndView checkCart(CartList cartList) {
        return null;
    }

    @Override
    public ModelAndView removeFromCart(CartList cartList) {
        return null;
    }

    @Override
    public ModelAndView updateProNum(CartList cartList) {
        return null;
    }

    @Override
    public ModelAndView removeAll(CartList cartList) {
        return null;
    }

    @Override
    public void setDao(DaoInterface dao) {
        this.dao=dao;
    }
}
