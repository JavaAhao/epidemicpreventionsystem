package com.ahao.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class LeaveVO {
    private Integer uid;
    private String uname;
    private String stuClass;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    private String leaveAddress;
    private String leaveReson;
    private Integer leaveStatus;
}
