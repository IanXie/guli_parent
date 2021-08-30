package com.paypal.metaservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * table details
 * </p>
 *
 * @author Xie Yin
 * @since 2021-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TableDetails对象", description="table details")
public class TableDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "database name")
    private String dbName;

    @ApiModelProperty(value = "table name")
    private String tableName;

    @ApiModelProperty(value = "view name")
    private String viewName;

    @ApiModelProperty(value = "sql name")
    private String sqlName;

    @ApiModelProperty(value = "sql path")
    private String sqlPath;

    @ApiModelProperty(value = "owner name")
    private String owner;

    @ApiModelProperty(value = "table description")
    private String tableDesc;

    @ApiModelProperty(value = "sort column")
    private Integer sort;

    @ApiModelProperty(value = " 1（true）deleted， 0（false）not deleted")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "create time")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "update time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
