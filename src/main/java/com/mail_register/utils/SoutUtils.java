package com.mail_register.utils;

/***
 * 错误代码的定义枚举类
 */
public enum SoutUtils {
     UUID_001(001,"账号或密码错误!"),
     UUID_002(002,"注册成功!"),
     UUID_003(003,"注册失败!"),
     UUID_004(004,"登录成功!"),
     UUID_005(005,"登录失败!"),
    ;

    private int code;
    private String errMsg;
    SoutUtils(int code,String errMsg) {
       this.code=code;
       this.errMsg=errMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
