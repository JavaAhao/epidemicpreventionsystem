package com.ahao.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class SpecialReportVO {
    private Integer UID;
    private String uname;
    private String sex;
    private String tel;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    private Integer temp;
    private String reson;
    private String address;
}
