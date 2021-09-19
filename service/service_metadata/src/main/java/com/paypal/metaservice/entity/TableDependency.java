package com.paypal.metaservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * table dependency
 * </p>
 *
 * @author Xie Yin
 * @since 2021-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TableDependency对象", description="table dependency")
public class TableDependency implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "table id")
    private Integer id;

    @ApiModelProperty(value = "table name")
    private String tableName;

    @ApiModelProperty(value = "parent id")
    private Integer parentId;

    @ApiModelProperty(value = "sort column")
    private Integer sort;

    @ApiModelProperty(value = "create time")
    private Date gmtCreate;

    @ApiModelProperty(value = "update time")
    private Date gmtModified;


}
