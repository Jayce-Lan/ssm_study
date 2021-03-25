package com.ssm.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆账号
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 注册时间
     */
    private Date registertime;

    /**
     * 注册状态，1：未启用；2：已启用；3：被禁用
     */
    private String status;

    /**
     * 角色id，外键
     */
    private Integer roleid;

    private String roleName;

    private static final long serialVersionUID = 1L;
}