package com.mail_register.service.Impl;

import com.mail_register.dao.ItripUserLinkUserMapper;
import com.mail_register.model.ItripUserLinkUser;
import com.mail_register.service.ItripUserLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItripUserLinkUserServiceImpl implements ItripUserLinkUserService {
    @Autowired
    private ItripUserLinkUserMapper itripUserLinkUserMapper;

    @Override
    public boolean registerUserOnLogin(ItripUserLinkUser itripUserLinkUser) {
        return itripUserLinkUserMapper.registerUserOnLogin(itripUserLinkUser) > 0 ? true : false;
    }
}
