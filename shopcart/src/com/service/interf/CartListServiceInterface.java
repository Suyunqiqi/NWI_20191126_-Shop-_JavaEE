package com.service.interf;

import com.pojo.CartList;
import com.pojo.ModelAndView;

public interface CartListServiceInterface extends ServiceInterface{
    //添加到购物车,cartList中包含：cid，pid
    ModelAndView addToCart(CartList cartList);
    //查看购物车，cartList包含：cid
    ModelAndView checkCart(CartList cartList);
    //把商品移除购物车，cartList中包含：pid，cid
    ModelAndView removeFromCart(CartList cartList);
    //修改购物车的商品数量，cartList包含：商品数量，pid，cid
    ModelAndView updateProNum(CartList cartList);
    //下单时清除购物车，cartList中包含cid
    ModelAndView removeAll(CartList cartList);
}