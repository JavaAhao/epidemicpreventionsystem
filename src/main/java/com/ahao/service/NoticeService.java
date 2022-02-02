package com.ahao.service;

import com.ahao.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ahao
 * @since 2021-12-10
 */
public interface NoticeService extends IService<Notice> {

    //获取所有通知
    List<Notice> getAllNotice();

    void adminDeleteNotice(Integer id);

    //关键字模糊查询
    List<Notice> likeQuery(String search);

    //发布通知
    int addNotice(Notice notice);
}
