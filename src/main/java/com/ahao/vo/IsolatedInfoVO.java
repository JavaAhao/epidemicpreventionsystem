package com.ahao.vo;

import com.ahao.entity.IsolatedInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class IsolatedInfoVO extends IsolatedInfo implements Serializable {
    private Integer uid;
    private String uname;
    private String stuClass;
    private Integer age;
    private String sex;
    private String tel;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime startTime;
    private Integer remainTime;
    private String address;
    private Integer status;
}
