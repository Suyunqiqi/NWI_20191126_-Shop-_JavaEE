package com.dao.interf;

import java.sql.ResultSet;

public interface DaoInterface {
    //获取连接
    void createConn() throws Exception;
    //创建语句对象
    void createPtmt(String sql,Object...params) throws Exception;
    //执行查询
    ResultSet query() throws Exception;
    //执行更新
    int update() throws Exception;
    //关闭资源
    void closeRs(ResultSet rs) throws Exception;
    void closePtmt() throws Exception;
    void closeConn() throws Exception;
}