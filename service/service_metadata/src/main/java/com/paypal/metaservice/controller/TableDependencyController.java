package com.paypal.metaservice.controller;


import com.atguigu.commonutils.R;
import com.paypal.metaservice.entity.TableDependency;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import com.paypal.metaservice.service.TableDependencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * table dependency 前端控制器
 * </p>
 *
 * @author Xie Yin
 * @since 2021-09-18
 */

@Api(tags = "Table Dependency Management")
@RestController
@RequestMapping("/metaservice/table-dependency")
@CrossOrigin
public class TableDependencyController {

    @Autowired
    TableDependencyService tableDependencyService;

    @ApiOperation(value = "查询表的血缘关系")
    @PostMapping("tableLineage")
    public R getChildTablesByName(@RequestBody(required = false) LineageQuery lineageQuery){
        List<TableDependency> depData = tableDependencyService
            .getDependencyByName(lineageQuery);
        return R.ok().data("data", depData);
    }
}

