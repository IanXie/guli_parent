package com.paypal.metaservice.controller;


import com.atguigu.commonutils.R;
import com.paypal.metaservice.entity.TableDependency;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import com.paypal.metaservice.service.TableDependencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    @PostMapping("getLineage")
    public R getChildTablesByName(@RequestBody(required = false) LineageQuery lineageQuery){
        // 这里没必要返回List,一个表只对应一个对象，前端也只能传数据对象data:{}
//        List<LinkedHashMap> resultData = tableDependencyService
//            .getDependencyByName(lineageQuery);
        Map<String, LinkedHashMap> resultData = tableDependencyService
            .getDependencyByName(lineageQuery);

        return R.ok().data("lineage", resultData.get("result"));
    }
}

