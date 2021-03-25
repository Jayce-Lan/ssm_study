package com.ssm.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * role
 * @author 
 */
@Data
public class Role implements Serializable {
    /**
     * 角色id
     */
    private Integer roleid;

    /**
     * 角色名称
     */
    private String rolename;
    //对应的用户列表
    private List<User> userList;

    private static final long serialVersionUID = 1L;
}