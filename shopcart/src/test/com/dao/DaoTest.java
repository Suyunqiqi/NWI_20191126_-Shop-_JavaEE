package test.com.dao;

import com.dao.impl.DaoImpl;
import org.junit.Test;

public class DaoTest {
    @Test
    public void testConn(){
        DaoImpl di=new DaoImpl();
        try {
            di.createConn();
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(di.getConn());
    }
}
