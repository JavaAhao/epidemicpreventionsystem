package com.ahao.service.impl;

import com.ahao.common.Result;
import com.ahao.entity.Notice;
import com.ahao.mapper.NoticeMapper;
import com.ahao.service.NoticeService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ahao
 * @since 2021-12-10
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> getAllNotice() {
        return noticeMapper.selectList(null);
    }

    @Override
    public void adminDeleteNotice(Integer id) {
        noticeMapper.deleteById(id);
    }

    //关键字模糊查询
    @Override
    public List<Notice> likeQuery(String search) {
      return noticeMapper.selectList(Wrappers.<Notice>lambdaQuery().like(Notice::getNotificationPublishe,search));

    }

    //发布通知
    @Override
    public int addNotice(Notice notice) {
        Date date = new Date();
        notice.setAddTime(date);
        return noticeMapper.insert(notice);
    }
}
