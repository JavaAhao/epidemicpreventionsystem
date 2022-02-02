package com.ahao.mapper;

import com.ahao.entity.Admin;
import com.ahao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    //判断原密码是否正确
    @Select("select * from admin where a_id=#{uid} and a_password=#{pass}" )
    public Admin selectOneByuid(@Param("uid")Integer uid, @Param("pass")String pass);
}
