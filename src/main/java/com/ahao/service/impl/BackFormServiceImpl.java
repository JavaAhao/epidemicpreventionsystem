package com.ahao.service.impl;

import com.ahao.common.Result;
import com.ahao.entity.BackForm;
import com.ahao.mapper.BackFormMapper;
import com.ahao.service.BackFormService;
import com.ahao.vo.BackFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackFormServiceImpl implements BackFormService {

    @Autowired
    BackFormMapper backFormMapper;

    //查询所有返校申请表
    @Override
    public List<BackFormVO> getAll(String search) {
        return backFormMapper.getAll(search);
    }

    //修改返校申请表通过状态(通过)
    @Override
    public int updateAuditStatus(Integer uid) {
        return backFormMapper.updateAuditStatus(uid);
    }

    //修改返校申请表通过状态（拒绝）
    @Override
    public int auditStatusRefuse(Integer uid, String refuseReson) {
        return backFormMapper.auditStatusRefuse(uid,refuseReson);
    }

    //查询所有学生返校申请表
    @Override
    public List<BackFormVO> getAllStudent(String search) {
        return backFormMapper.getAllStudent(search);

    }

    //提交返校申请表
    @Override
    public Result<?> add(BackForm backForm) {
        if (backForm.getTemp()>37.3){
            backForm.setReson("体温大于37.3℃");
        }
        int i = backFormMapper.insert(backForm);
        if (i>0){
            return Result.success();
        }
        return Result.error("-1","提交失败");
    }
}
