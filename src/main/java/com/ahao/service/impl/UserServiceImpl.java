package com.ahao.service.impl;

import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.BackForm;
import com.ahao.entity.User;
import com.ahao.mapper.BackFormMapper;
import com.ahao.mapper.UserMapper;
import com.ahao.service.UserService;
import com.ahao.vo.BackFormVO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BackFormMapper backFormMapper;

    //用户登录
    @Override
    public Result<?> login(Integer id, String password, Integer loginAccount) {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUid, id));
        if (user!=null){
            User user1 = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getPassword, password).eq(User::getLoginAccount, loginAccount));
            if (user1!=null){
                user1.setPassword(null);
                return Result.success(user1);
            }
            return Result.error("-1","密码错误！");
        }
        return Result.error("-1","用户不存在！");
    }

    //用户查询返校申请提交历史
    @Override
    public List<BackFormVO> getBackForm() {
        return backFormMapper.getPersonAll();
    }

    //修改用户隔离状态
    @Override
    public void addIsolation(Integer uid) {
         userMapper.addIsolation(uid);
    }

    //更改用户隔离状态
    @Override
    public void updateStatus(Integer uid) {
        userMapper.updateStatusByUid(uid);
    }

    @Override
    public User selectByUId(Integer uid) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUid,uid));
    }
    //修改密码
    @Override
    public Result<?> updatePassword(Integer uid, String pass, String password) {
        User user = userMapper.selectOneByuid(uid,pass);
        if (user==null){
            return Result.error("-1","原密码错误！");
        }
        user.setPassword(password);
        userMapper.updateById(user);
        return Result.success(user);
    }

    @Override
    public Result<?> getAll() {
        List<User> users = userMapper.selectList(null);
        return Result.success(users);
    }
}
