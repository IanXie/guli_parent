package com.paypal.metaservice.entity.lineage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LineageQuery {

  @ApiModelProperty(value = "数据库", example = "pp_cs_ods")
  private String db;

  @ApiModelProperty(value = "表名", example = "fact_cs_ee_case")
  private String name;

}
