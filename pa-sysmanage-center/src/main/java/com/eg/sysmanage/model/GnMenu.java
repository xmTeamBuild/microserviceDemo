package com.eg.sysmanage.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shenzq
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GnMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单说明
     */
    private String menuDesc;

    /**
     * 父级菜单id
     */
    private Integer menuPid;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 菜单顺序
     */
    private Integer menuOrder;

    private String menuTarget;

    /**
     * 菜单路径
     */
    private String menuUrl;

    private String menuPic;

    private String rightTag;

    /**
     * 生效时间
     */
    private Timestamp activeTime;

    /**
     * 失效时间
     */
    private Timestamp inactiveTime;

    private String treeDisplay;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建员工
     */
    private Integer createOperId;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 更新员工
     */
    private Integer updateOperId;

    /**
     * 是否展示,1是0否
     */
    private String isShow;

    /**
     * 功能权类型
     */
    private String funcType;

    /**
     * 菜单英文名称
     */
    private String menuEnName;

    private String meneIcon;


}
