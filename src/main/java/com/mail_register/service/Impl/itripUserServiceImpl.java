package com.mail_register.service.Impl;

import com.mail_register.dao.ItripUserLinkUserMapper;
import com.mail_register.dao.ItripUserMapper;
import com.mail_register.model.ItripUser;
import com.mail_register.model.ItripUserLinkUser;
import com.mail_register.service.ItripUserLinkUserService;
import com.mail_register.service.ItripUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class itripUserServiceImpl implements ItripUserService {
    @Autowired
    private ItripUserMapper itripUserMapper;

    @Autowired
    private ItripUserLinkUserService itripUserLinkUserService;

    @Override
    public boolean register(ItripUser itripUser) {
        return itripUserMapper.register(itripUser) > 0 ? true : false;
    }


    /***
     * 注册主方法
     * @param email
     * @param userName
     * @param activated
     * @param pwd
     * @param
     * @return
     */
    @Override
    public boolean registerAllUser(String email, String userName, Integer activated, String pwd) {
        ItripUser itripUser = new ItripUser(email, pwd, userName, activated);
        Integer userId = itripUser.getId();
        boolean bool = this.register(itripUser);
        if (bool) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ItripUser login(String usercode,String userPassword) {
        ItripUser itripUser=new ItripUser();
        itripUser.setUsercode(usercode);
        itripUser.setUserpassword(userPassword);
        ItripUser login = itripUserMapper.login(itripUser);
        if(login!=null){
           return login;
        }else{
            return null;
        }
    }

    @Override
    public boolean findByUserCode(String usercode) {
        return itripUserMapper.selectCzEmail(usercode) > 0 ? true : false;
    }
}
