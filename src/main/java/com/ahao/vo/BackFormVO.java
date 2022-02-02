package com.ahao.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BackFormVO {
    private Integer uid;
    private String uname;
    private String sex;
    private String college;
    private String tel;
    private Integer temp;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    private String vehicle;
    private String vehicleTrips;
    private Integer auditStatus;
    private String reson;
    private String address;
    private String startAddress;
    private String refuseReson;
}
