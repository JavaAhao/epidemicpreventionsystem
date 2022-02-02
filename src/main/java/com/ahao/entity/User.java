package com.ahao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Ahao
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生为学号id；教师为教职工id；
     */
    private Integer uid;

    /**
     * 用户姓名
     */
    private String uName;

    /**
     * 密码
     */
    private String password;

    /**
     * 学院
     */
    private String college;

    /**
     * 班级
     */
    private String stuClass;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话
     */
    private String tel;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 1为学生；2为教室
     */
    private String loginAccount;


}
