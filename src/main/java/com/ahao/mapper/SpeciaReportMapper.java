package com.ahao.mapper;

import com.ahao.entity.SpecialReport;
import com.ahao.vo.SpecialReportVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ahao
 * @since 2021-11-08
 */
@Repository
public interface SpeciaReportMapper extends BaseMapper<SpecialReport> {

    @Select("select * from special_report,user where special_report.uid=user.uid and u_name like '%${search}%'")
    public List<SpecialReportVO> getAll(String search);

    //根据uid查询用户
    @Select("select * from special_report where uid=#{uid}")
    public SpecialReport selectByUid(Integer uid);

    //根据uid将已经隔离的用户从健康表中删除
    @Delete("DELETE FROM `special_report` WHERE `uid` = #{uid}")
    void deleteByuid(@Param("uid") Integer uid);
}
