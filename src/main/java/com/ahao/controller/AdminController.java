package com.ahao.controller;


import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.User;
import com.ahao.service.AdminService;
import com.ahao.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ahao
 * @since 2021-11-08
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody UserVo user){
        return adminService.login(user);
    }

    //查询所有学生信息
    @PostMapping("/getAll")
    public List<User> getAll() {
        List<User> UserList = adminService.getAllUsers();
        return UserList;
    }

    //添加学生
    @PostMapping("/addUser")
    public Result<?> save(@RequestBody User User){
        return adminService.addUser(User);
    }


    //姓名查询
    @GetMapping("/getOne")
    public Result<?> getOne(@RequestParam String name){
        return adminService.getOne(name);
    }


    //分页查询
    @GetMapping("/findPage")
    public Result<?> findPage(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize,
                              @RequestParam String search){
        return adminService.findPage(pageNum, pageSize, search);
    }

    @PostMapping("/updateUser")
    public Result<?> updateUser(@RequestBody User User){
        return adminService.updateStudednt(User);
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteUser(@PathVariable Integer id){
        adminService.deleteUser(id);
        return Result.success();
    }

    //查询密码
    @GetMapping("/queryPassword/{id}")
    public Result<?> queryPassword(@PathVariable Integer id){
        return adminService.selectByUid(id);
    }

    //修改密码
    @GetMapping("/updatePassword")
    public Result<?> updatePassword(@RequestParam Integer id,
                                    @RequestParam(value = "pass",required = false) String pass,
                                    @RequestParam(value = "password",required = false) String password
    ) {
        return adminService.updatePassword(id, pass, password);
    }


}

