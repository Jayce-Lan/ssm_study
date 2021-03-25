package com.ssm.dao;

import com.ssm.pojo.Role;

import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAll();

    Role selectById(Integer roleid);
}