package com.ahao.service.impl;

import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.User;
import com.ahao.mapper.AdminMapper;
import com.ahao.mapper.UserMapper;
import com.ahao.service.AdminService;
import com.ahao.vo.UserVo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-08
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<?> login(UserVo userVo) {
        Admin admin = adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getAId, userVo.getUid()));
        if (admin!=null){
            Admin admin1 = adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getAPassword, userVo.getPassword()));
            if (admin1!=null){
                admin1.setAPassword(null);
                return Result.success(admin1);
            }
            return Result.error("-1","密码错误！");
        }
        return Result.error("-1","用户不存在！");
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    //添加用户
    @Override
    public Result<?> addUser(User User) {
        int insert = userMapper.insert(User);
        if (insert>0){
            return Result.success();
        }
        return Result.error("-1","添加失败！");
    }

    //分页查询所有用户
    @Override
    public Result<?> findPage(Integer pageNum, Integer pageSize, String search) {
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<User>lambdaQuery().like(User::getUName, search));
        return Result.success(userPage);
    }

    //更新用户
    @Override
    public Result<?> updateStudednt(User User) {
        int i = userMapper.updateById(User);
        return Result.success();
    }

    //删除用户
    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    //根据aid查密码
    @Override
    public Result<?> selectByUid(Integer id) {
        Admin admin = adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getAId, id));
        return Result.success(admin);
    }

    //修改密码
    @Override
    public Result<?> updatePassword(Integer id, String pass, String password) {
        Admin admin = adminMapper.selectOneByuid(id,pass);
        if (admin==null){
            return Result.error("-1","原密码错误！");
        }
        admin.setAPassword(password);
        int i = adminMapper.updateById(admin);
        return Result.success(admin);
    }

    @Override
    public Result<?> getOne(String uname) {
        List<User> list = userMapper.selectList(Wrappers.<User>lambdaQuery().like(User::getUName,uname));
        return Result.success(list);
    }
}
