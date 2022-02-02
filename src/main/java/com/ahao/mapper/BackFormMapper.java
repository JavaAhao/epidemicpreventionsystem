package com.ahao.mapper;

import com.ahao.entity.BackForm;
import com.ahao.vo.BackFormVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackFormMapper extends BaseMapper<BackForm> {
    //查询所有返校申请表
    @Select("select * from back_form,user where back_form.uid=user.uid and audit_status=0 and u_name like '%#{search}#'")
    public List<BackFormVO> getAll(String search);

    //修改返校申请表通过状态(通过）
    @Update("UPDATE `back_form` SET `audit_status` = 1 WHERE `uid` = #{uid}")
    public int updateAuditStatus(@Param("uid")Integer uid);

    //修改返校申请表通过状态(拒绝）
    @Update("UPDATE `back_form` SET `audit_status` = 2,`refuse_reson` = #{refuseReson} WHERE `uid` = #{uid}")
    public int auditStatusRefuse(@Param("uid")Integer uid, @Param("refuseReson")String refuseReson);

    //用户查询返校申请提交历史
    @Select("select * from back_form,user where back_form.uid=user.uid")
    public List<BackFormVO> getPersonAll();

    //查询所有返校申请表
    @Select("select * from back_form,user where back_form.uid=user.uid and audit_status=0 and login_account=3")
    public List<BackFormVO> getAllStudent(@Param("search") String search);
}
