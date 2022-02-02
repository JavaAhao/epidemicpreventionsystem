package com.ahao.controller;


import com.ahao.common.Result;
import com.ahao.entity.Leave;
import com.ahao.service.LeaveService;
import com.ahao.vo.LeaveVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ahao
 * @since 2021-11-21
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    //获取所有请假
    @GetMapping("/getAll")
    public Result<?> getAll(){
        List<LeaveVO> list = leaveService.getAll();
        return Result.success(list);
    }

    //添加假条
    @PostMapping("/addLeave")
    public Result<?> addLeave(@RequestBody Leave leave){
        int i = leaveService.addLeave(leave);
        return Result.success(i);
    }

    //历史假条
    @GetMapping("/{id}")
    public Result<?> getPersonalLeaves(@PathVariable Integer id){
        List<LeaveVO> list = leaveService.getPersonalLeaves(id);
        return Result.success(list);
    }

    //批阅(通过）假条
    @GetMapping("/handlePass/{id}")
    public Result<?> handlePass(@PathVariable Integer id){
        return leaveService.handlePass(id);
    }

    //批阅(拒绝）假条
    @GetMapping("/handleRefuse/{id}")
    public Result<?> handleRefuse(@PathVariable Integer id){
        return leaveService.handleRefuse(id);
    }
}

