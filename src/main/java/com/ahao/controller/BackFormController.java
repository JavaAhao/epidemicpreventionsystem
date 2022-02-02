package com.ahao.controller;

import com.ahao.common.Result;

import com.ahao.entity.BackForm;
import com.ahao.service.BackFormService;
import com.ahao.vo.BackFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialPerson")
public class BackFormController {
    @Autowired
    BackFormService backFormService;

    //提交返校申请表
    @PostMapping("/backform")
    public Result<?> submit(@RequestBody BackForm backForm){
        return backFormService.add(backForm);
    }

    //获取所有返校申请表
    @GetMapping("/getAll")
    public Result<?> getAll(@RequestParam String search){
        List<BackFormVO> list = backFormService.getAll(search);
        return Result.success(list);
    }

    //修改返校申请表通过状态
    @PutMapping("/pass/{uid}")
    public Result<?> updateAuditStatus(@PathVariable Integer uid){
        backFormService.updateAuditStatus(uid);
        return Result.success();
    }

    //修改返校申请表通过状态(拒绝)
    @GetMapping("/refuse")
    public Result<?> updateAuditStatusRe(Integer id,String refuseReson){
        backFormService.auditStatusRefuse(id,refuseReson);
        return Result.success();
    }

    //获取学生返校申请表
    @GetMapping("/getAllStudent")
    public Result<?> getAllStudent(@RequestParam String search){
        List<BackFormVO> list = backFormService.getAllStudent(search);
        return Result.success(list);
    }
}
