package com.ahao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SpecialReport implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer uid;

    private Double temp;

    private Date date;

    private String reson;

    private String riskArea;


}
