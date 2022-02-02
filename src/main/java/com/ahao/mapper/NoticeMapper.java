package com.ahao.mapper;

import com.ahao.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.Constants.WHERE;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ahao
 * @since 2021-12-10
 */
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {

  /*  @Select("SELECT * FROM `notice` WHERE CONCAT(notification_publishe,notification_type,notice_title) LIKE `%#{search}%`")
    public List selectKeyWordList(@Param("search")String search);*/
}
