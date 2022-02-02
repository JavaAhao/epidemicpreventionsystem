package com.ahao.service;

import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.User;
import com.ahao.vo.UserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService{
    //用户登录
    public Result<?> login(UserVo userVo);

    //查询所有用户信息
    public List<User> getAllUsers();

    //添加用户
    public Result<?> addUser(User User);

    //分页查询
    public Result<?> findPage(Integer pageNum, Integer pageSize, String search);

    //修改用户
    public Result<?> updateStudednt(User User);

    //删除用户
    public void deleteUser(Integer id);

    //根据aid查密码
    Result<?> selectByUid(Integer id);

    //修改密码
    Result<?> updatePassword(Integer id, String pass, String password);

    //姓名查询用户
    Result<?> getOne(String uname);
}
