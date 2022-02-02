package com.ahao.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Ahao
 * @since 2021-11-08
 */
@TableName("isolated_info")
@Data
@EqualsAndHashCode(callSuper = false)
public class IsolatedInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer uid;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime startTime;

    private Integer remainTime;

    private String reson;

}
