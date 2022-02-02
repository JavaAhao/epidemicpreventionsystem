package com.ahao.controller;


import com.ahao.common.Result;
import com.ahao.entity.Notice;
import com.ahao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ahao
 * @since 2021-12-10
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    //获取所有通知
    @GetMapping("/getAllNotice")
    public Result<?> getAllNotice(){
        List<Notice> allNotice = noticeService.getAllNotice();
        return Result.success(allNotice);
    }

    //管理员删除通知
    @DeleteMapping("/deleteNotice/{id}")
    public Result<?> deleteNotice(@PathVariable Integer id){
        noticeService.adminDeleteNotice(id);
        return Result.success();
    }

    //关键字模糊查询
    @RequestMapping("/query/{search}")
    public Result<?> deleteNotice(@PathVariable String search){
        List<Notice> notices = noticeService.likeQuery(search);
        return Result.success(notices);
    }

    //发布通知
    @PostMapping("/addNotice")
    public Result<?> addNotice(@RequestBody Notice notice){
        int i = noticeService.addNotice(notice);
        return Result.success(i);
    }
}
