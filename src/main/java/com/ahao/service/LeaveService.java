package com.ahao.service;

import com.ahao.common.Result;
import com.ahao.entity.Leave;
import com.ahao.vo.LeaveVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-21
 */
public interface LeaveService extends IService<Leave> {

    //获取所有请假
    List<LeaveVO> getAll();

    //添加假条
    int addLeave(Leave leave);

    //历史假条
    List<LeaveVO> getPersonalLeaves(Integer id);

    //批阅假条（通过）
    Result<?> handlePass(Integer uid);

    //批阅(拒绝）假条
    Result<?> handleRefuse(Integer uid);
}
