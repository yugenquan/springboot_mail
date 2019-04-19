package com.mail_register.service;

import com.mail_register.model.ItripUser;

public interface ItripUserService {
    boolean register(ItripUser itripUser);

    boolean registerAllUser(String email, String userName, Integer activated, String pwd);

    boolean findByUserCode(String usercode);

    ItripUser login(String usercode,String userPassword);
}
