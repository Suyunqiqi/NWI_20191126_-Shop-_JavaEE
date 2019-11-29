package com.service.impl;

import com.dao.interf.DaoInterface;
import com.pojo.ModelAndView;
import com.pojo.Product;
import com.service.interf.ProductServiceInterface;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductServiceInterface {
    private DaoInterface dao;
    @Override
    public ModelAndView querryAllPro() {
        ModelAndView modelAndView=new ModelAndView();
        String sql="select * from product where totop='1'";
        ResultSet rs=null;
        try {
            dao.createPtmt(sql);
            rs=dao.query();
            List<Product> products=new ArrayList<>();
            while(rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDicount(rs.getDouble("dicount"));
                product.setImg(rs.getString("img"));
                products.add(product);
            }
            modelAndView.setObject(products);
            modelAndView.setFlag("666");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setFlag("101");
        }finally {
            try {
                dao.closeRs(rs);
                dao.closePtmt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return modelAndView;
    }

    @Override
    public void setDao(DaoInterface dao) {
        this.dao=dao;
    }
}
