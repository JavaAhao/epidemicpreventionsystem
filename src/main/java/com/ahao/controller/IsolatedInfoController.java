package com.ahao.controller;


import com.ahao.common.Result;
import com.ahao.entity.IsolatedInfo;
import com.ahao.entity.User;
import com.ahao.service.IsolatedInfoService;
import com.ahao.service.SpecialReportService;
import com.ahao.service.UserService;
import com.ahao.vo.IsolatedInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/isolatedInfo")
public class IsolatedInfoController {
    @Resource
    IsolatedInfoService isolatedInfoService;
    @Autowired
    UserService userService;
    @Autowired
    SpecialReportService specialReportService;

    //查询个人隔离信息
    @GetMapping("/getIsolatedInfo/{id}")
    public Result<?> getIsolatedInfo(@PathVariable Integer id) {
        IsolatedInfo IsoMsg = isolatedInfoService.getIsolatedInfo(id);
        return Result.success(IsoMsg);
    }

    //分页联合查询所有隔离人员信息
    @GetMapping("/getAllisolatedPerson")
    public Result<?> getAllisolatedPerson(@RequestParam String search) {
        List<IsolatedInfoVO> allisolatedPerson = isolatedInfoService.getAllisolatedPerson(search);
        return Result.success(allisolatedPerson);
    }

    //添加隔离人员
    @PutMapping("/{uid}")
    public Result<?> addIsolation(@PathVariable Integer uid) {

        userService.addIsolation(uid);
        isolatedInfoService.addIsolation(uid);
        specialReportService.deleteByuid(uid);
        return Result.success();
    }

    //删除隔离人员
    @DeleteMapping("/{uid}")
    public Result<?> deleteIsolation(@PathVariable Integer uid) {
        userService.updateStatus(uid);
        isolatedInfoService.deleteIsolation(uid);
        return Result.success();
    }

}

