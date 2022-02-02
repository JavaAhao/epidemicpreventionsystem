package com.ahao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    private Integer id;
    private Integer aId;
    private String aPassword;
}
