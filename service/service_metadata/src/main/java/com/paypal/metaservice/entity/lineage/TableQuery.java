package com.paypal.metaservice.entity.lineage;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TableQuery {

    @ApiModelProperty(value = "数据库名称", example = "pp_cs_ods")
    private String db;

    @ApiModelProperty(value = "表名,模糊查询", example = "fact_cs_ee_case")
    private String name;

    @ApiModelProperty(value = "owner", example = "GCCI")
    private String owner;

    @ApiModelProperty(value = "查询开始时间", example = "2021-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2022-01-01 10:10:10")
    private String end;

}
