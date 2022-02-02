package com.ahao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Ahao
 * @since 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "student_leave")
public class Leave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Date startDate;

    private Date overDate;

    private String leaveAddress;

    private String leaveReson;

    private Integer leaveStatus;


}
