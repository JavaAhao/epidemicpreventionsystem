package com.ahao.mapper;

import com.ahao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ahao
 * @since 2021-11-11
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    //修改用户为隔离状态
    @Update("update user set status=1 where uid=#{id}")
    public void addIsolation(Integer id);

    //取消用户隔离状态
    @Update("update user set status=0 where uid=#{uid}")
    public void updateStatusByUid(@Param("uid")Integer uid);

    //判断原密码是否正确
    @Select("select * from user where uid=#{uid} and password=#{pass}" )
    public User selectOneByuid(@Param("uid")Integer uid,@Param("pass")String pass);
}
