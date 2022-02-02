package com.ahao.service;

import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.BackForm;
import com.ahao.entity.User;
import com.ahao.vo.BackFormVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-11
 */
public interface UserService extends IService<User> {

    //用户登录
    public Result<?> login(Integer id, String password,Integer loginAccount);

    //用户查询返校申请提交历史
    List<BackFormVO> getBackForm();

    //修改用户隔离状态
    void addIsolation(Integer uid);

    //更改用户隔离状态
    void updateStatus(Integer uid);

    User selectByUId(Integer uid);

    //修改密码
    Result<?> updatePassword(Integer uid, String pass, String password);

    Result<?> getAll();
}
