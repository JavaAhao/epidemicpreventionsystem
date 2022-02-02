package com.ahao.service;

import com.ahao.common.Result;
import com.ahao.entity.BackForm;
import com.ahao.vo.BackFormVO;

import java.util.List;

public interface BackFormService {
    //查询所有返校申请表
    List<BackFormVO> getAll(String search);

    //修改返校申请表通过状态（通过）
    int updateAuditStatus(Integer uid);

    //修改返校申请表通过状态（拒绝）
    int auditStatusRefuse(Integer uid,String refuseReson);

    //获取学生返校申请表
    List<BackFormVO> getAllStudent(String search);

    Result<?> add(BackForm backForm);
}
