package com.ahao.mapper;

import com.ahao.entity.IsolatedInfo;
import com.ahao.vo.IsolatedInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
public interface IsolatedInfoMapper extends BaseMapper<IsolatedInfo> {

    //查询所有隔离人员信息
    @Select("select * from isolated_info,user where isolated_info.uid=user.uid and u_name like '%${search}%' and status=1")
    public List<IsolatedInfoVO> getAllisolatedPerson(String search);

    //添加隔离人员
    @Insert("INSERT INTO `isolated_info`(`uid`, `start_time`, `reson`) VALUES (#{uid},#{date},#{reson})")
    public int addIsolation(@Param("uid")Integer uid, @Param("date") Date date, @Param("reson")String reson);

    //删除隔离人员
    @Delete("delete from `isolated_info` where uid=#{uid}")
    public int deleteByUid(@Param("uid") Integer uid);

    //查询隔离信息
    @Select("select * from isolated_info,user where isolated_info.uid=user.uid and user.uid=#{id}")
    public IsolatedInfoVO selectByUid(@Param("id") Integer id);
}

