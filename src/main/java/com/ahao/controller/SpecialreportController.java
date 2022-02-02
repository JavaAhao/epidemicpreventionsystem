package com.ahao.controller;


import com.ahao.common.Result;
import com.ahao.entity.SpecialReport;
import com.ahao.entity.User;
import com.ahao.service.SpecialReportService;
import com.ahao.service.UserService;
import com.ahao.vo.SpecialReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/specialReport")
public class SpecialreportController {
    @Autowired
    SpecialReportService specialReportService;
    @Autowired
    UserService userService;

    //提交健康表
    @PostMapping("/healthForm")
    public Result<?> login(@RequestBody SpecialReport report) {
        User user = userService.selectByUId(report.getUid());
        if (user==null){
            return Result.error("-1","学号错误");
        }
        specialReportService.addHealthForm(report);
        return Result.success();
    }


    //查询上报总数
    @GetMapping("/getTotal")
    public Result<?> getTotal() {
        return specialReportService.getTotal();
    }

    //查询所有用户异常用户
    @GetMapping("/getAll")
    public Result<?> getAll(@RequestParam String search) {
        List<SpecialReportVO> specialReport = specialReportService.getAll(search);
        return Result.success(specialReport);
    }

    //删除异常人员
    @DeleteMapping("/{uid}")
    public Result<?> deleteUser(@PathVariable Integer uid) {
        specialReportService.delete(uid);
        return Result.success();
    }

}


