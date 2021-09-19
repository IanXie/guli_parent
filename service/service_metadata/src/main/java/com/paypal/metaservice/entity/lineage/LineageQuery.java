package com.paypal.metaservice.entity.lineage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LineageQuery {

  @ApiModelProperty(value = "数据库")
  private String db;

  @ApiModelProperty(value = "表名")
  private String name;

}
