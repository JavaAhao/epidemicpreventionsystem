package com.ahao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BackForm {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Double temp;
    private Date date;
    private String vehicle;
    private String reson;
    private String vehicleTrips;
    private String startAddress;
    private Integer auditStatus;
}
