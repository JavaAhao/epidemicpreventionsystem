package com.ahao.mapper;

import com.ahao.entity.Leave;
import com.ahao.vo.LeaveVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ahao
 * @since 2021-11-21
 */
@Repository
public interface LeaveMapper extends BaseMapper<Leave> {

    //获取所有请假
    @Select("select * from `student_leave`,`user` where student_leave.uid=user.uid and leave_status=0")
    public List<LeaveVO> getAll();

    //历史请假
    @Select("select * from `student_leave`,`user` where student_leave.uid=user.uid and user.uid=#{id}")
    public List<LeaveVO>  getPersonalLeaves(@Param("id") Integer id);

    //批阅假条（通过）
    @Update("UPDATE `student_leave` SET `leave_status` = 1 WHERE `uid` = #{uid}")
    public int handlePass(@Param("uid")Integer uid);

    //批阅假条（通过）
    @Update("UPDATE `student_leave` SET `leave_status` = 2 WHERE `uid` = #{uid}")
    public int handleRefuse(@Param("uid")Integer uid);

}
