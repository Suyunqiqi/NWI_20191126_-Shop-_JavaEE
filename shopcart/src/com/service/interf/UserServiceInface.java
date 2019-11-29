package com.service.interf;

import com.pojo.ModelAndView;
import com.pojo.Sq_user;

public interface UserServiceInface extends ServiceInterface {
    //登录
    ModelAndView login(Sq_user user);
    //注册
    ModelAndView register(String sql,Sq_user user);
    //修改个人信息
    ModelAndView updateInfo(String sql,Sq_user user);
    //查询所有
    ModelAndView queryAllUser(String sql);
    //删除---------慎用
    ModelAndView delUserById(String sql,int uid);
    //初始化密码
    ModelAndView initPwd();
}
