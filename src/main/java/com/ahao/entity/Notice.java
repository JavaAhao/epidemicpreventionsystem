package com.ahao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2021-12-10
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 发布者
     */
      private String notificationPublishe;

      /**
     * 通知对象
     */
      private String notifyObject;

      /**
     * 发布对象
     */
      @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
      private Date addTime;

      /**
     * 通知类型
     */
      private String notificationType;

      /**
     * 通知标题
     */
      private String noticeTitle;

      /**
     * 通知内容
     */
      private String noticeDetails;


}
