package com.ssm.service.impl;

import com.ssm.dao.TUserDao;
import com.ssm.entity.TUser;
import com.ssm.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TUserServiceImpl implements TUserService {
    @Autowired
    private TUserDao tUserDao;

    @Override
    public TUser findUserById(Integer id) {
        return this.tUserDao.queryById(id);
    }
}
