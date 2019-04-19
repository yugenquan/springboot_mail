package com.mail_register.dao;

import com.mail_register.model.ItripUser;

import java.util.List;

public interface ItripUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItripUser record);

    ItripUser selectByPrimaryKey(Long id);

    List<ItripUser> selectAll();

    int updateByPrimaryKey(ItripUser record);

    int register(ItripUser itripUser);

    int selectCzEmail(String userCode);

    ItripUser login(ItripUser itripUser);
}