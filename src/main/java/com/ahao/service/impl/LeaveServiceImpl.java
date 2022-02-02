package com.ahao.service.impl;

import com.ahao.common.Result;
import com.ahao.entity.Leave;
import com.ahao.mapper.LeaveMapper;
import com.ahao.service.LeaveService;
import com.ahao.vo.LeaveVO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-21
 */
@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

    @Autowired
    LeaveMapper leaveMapper;

    //获取所有请假
    @Override
    public List<LeaveVO> getAll() {
        return leaveMapper.getAll();
    }

    //添加假条
    @Override
    public int addLeave(Leave leave) {
       return leaveMapper.insert(leave);
    }

    @Override
    public List<LeaveVO> getPersonalLeaves(Integer id) {
        return  leaveMapper.getPersonalLeaves(id);
    }

    //批阅(通过）假条
    @Override
    public Result<?> handlePass(Integer uid) {
        int i = leaveMapper.handlePass(uid);
        if (i>0){
            return Result.success(i);
        }
        return Result.error("-1","内部服务器错误");
    }

    //批阅(拒绝）假条
    @Override
    public Result<?> handleRefuse(Integer uid) {
        int i = leaveMapper.handleRefuse(uid);
        if (i>0){
            return Result.success(i);
        }
        return Result.error("-1","内部服务器错误");
    }
}
