package com.mail_register.utils;

import java.util.UUID;

/***
 * UUID类随机生成一个32位编码的状态码
 */
public class RegisterUUID {
    public static String getEmailUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static Integer getPhoneUUID(){
       return (int)((Math.random()*9+1)*100000);
    }
}
