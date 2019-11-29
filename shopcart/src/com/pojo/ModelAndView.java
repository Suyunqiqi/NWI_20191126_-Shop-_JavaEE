package com.pojo;
/*
666:操作成功
101：数据库访问异常
102：账号错误
103：密码错误
 */
public class ModelAndView {
    private String flag;
    private Object object;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
