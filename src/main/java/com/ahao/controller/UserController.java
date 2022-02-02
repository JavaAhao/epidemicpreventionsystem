package com.ahao.controller;


import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.BackForm;
import com.ahao.entity.User;
import com.ahao.service.AdminService;
import com.ahao.service.UserService;
import com.ahao.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ahao
 * @since 2021-11-11
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @Autowired
    AdminService adminService;


    @PostMapping("/login")
    public Result<?> login(@RequestBody UserVo user){
        return userService.login(user.getUid(), user.getPassword(),user.getLoginAccount());
    }

    //查询用户总数
    @GetMapping("/getAll")
    public Result<?> getAll() {
        return userService.getAll();
    }


    //用户查询返校申请提交历史
    @GetMapping("/getBackForm")
    public Result<?> getBackForm() {

        return Result.success(userService.getBackForm());
    }

    //查询某个用户信息或者查询用户是否存在
    @GetMapping("getOne/{uid}")
    public Result<?> getOne(@PathVariable Integer uid) {
        User user = userService.selectByUId(uid);
        return Result.success(user);
    }

    //修改个人信息
    @PostMapping("/updateUser")
    public Result<?> update(@RequestBody User user) {
        return adminService.updateStudednt(user);
    }

    //修改密码
    @GetMapping("/updatePassword")
    public Result<?> updatePassword(@RequestParam Integer id,
                                    @RequestParam(value = "pass",required = false) String pass,
                                    @RequestParam(value = "password",required = false) String password
    ) {
        return userService.updatePassword(id, pass, password);
    }

}

