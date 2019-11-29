package com.dao.impl;

import com.dao.interf.DaoInterface;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImpl implements DaoInterface {
    private Connection conn;
    private PreparedStatement ptmt;
    @Override
    public void createConn() throws Exception {
        DataSource dataSource=new ComboPooledDataSource();
        conn=dataSource.getConnection();
    }

    @Override
    public void createPtmt(String sql, Object... params) throws Exception {
        ptmt=conn.prepareStatement(sql);
        for (int i=0;i<params.length;i++){
         ptmt.setObject(i+1,params[i]);
        }
        System.out.println(ptmt);
    }

    @Override
    public ResultSet query() throws Exception {
        return ptmt.executeQuery();
    }

    @Override
    public int update() throws Exception {
        return ptmt.executeUpdate();
    }

    @Override
    public void closeRs(ResultSet rs) throws Exception {
        if (rs!=null)
            rs.close();
    }

    @Override
    public void closePtmt() throws Exception {
        if (ptmt!=null)
            ptmt.close();
    }

    @Override
    public void closeConn() throws Exception {
        if (conn!=null)
            conn.close();
    }

    public Connection getConn() {
        return conn;
    }
}
