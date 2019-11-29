package com.service.impl;

import com.dao.interf.DaoInterface;
import com.pojo.ModelAndView;
import com.pojo.Sq_user;
import com.pojo.UserPlus;
import com.service.interf.UserServiceInface;

import java.sql.ResultSet;

public class UserServiceImpl implements UserServiceInface {
    private DaoInterface dao;
    ModelAndView modelAndView=new ModelAndView();
    @Override
    public ModelAndView login(Sq_user user) {

        UserServiceImpl userService=new UserServiceImpl();
        //String sql="select * from sq_user where uacc=?";
        String sql="SELECT u.uid,u.upwd,u.uname,c.cid FROM sq_user u,cart c WHERE u.uacc=? AND u.uid=c.uid";
        ResultSet rs=null;
        try {
            dao.createPtmt(sql,user.getUacc());
            rs=dao.query();
            if (rs.next()){
                if (user.getUpwd().equals(rs.getString("upwd"))){
                    UserPlus userPlus=new UserPlus();
                    userPlus.setUid(rs.getInt("uid"));
                    userPlus.setUpwd(rs.getString("upwd"));
                    userPlus.setUname(rs.getString("uname"));
                    userPlus.setCid(rs.getInt("cid"));
                    modelAndView.setObject(userPlus);
                    modelAndView.setFlag("666");
                }else {
                    modelAndView.setFlag("103");
                }
            }else{
                modelAndView.setFlag("102");
            }

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
    public ModelAndView register(String sql,Sq_user user) {
        return null;
    }

    @Override
    public ModelAndView updateInfo(String sql,Sq_user user) {
        return null;
    }

    @Override
    public ModelAndView queryAllUser(String sql) {
        return null;
    }

    @Override
    public ModelAndView delUserById(String sql,int uid) {
        return null;
    }

    @Override
    public ModelAndView initPwd() {
        return null;
    }

    @Override
    public void setDao(DaoInterface dao) {
        this.dao=dao;
    }
}
