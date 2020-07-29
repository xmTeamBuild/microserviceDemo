package com.eg.sysmanage.model;

import com.baomidou.mybatisplus.annotation.IdType;

import java.sql.Timestamp;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author shenzq
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Staff implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "staff_id", type = IdType.AUTO)
    private Integer staffId;

    private String staffName;

    private String staffNo;

    private Integer password;

    private Timestamp createData;

    private String createOper;

    private Timestamp updateDate;

    private String updateOper;


}
