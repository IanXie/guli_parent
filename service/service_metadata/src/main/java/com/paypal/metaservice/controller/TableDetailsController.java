package com.paypal.metaservice.controller;


import com.atguigu.commonutils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.paypal.metaservice.entity.TableDetails;
import com.paypal.metaservice.entity.lineage.TableQuery;
import com.paypal.metaservice.service.TableDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * table details 前端控制器
 * </p>
 *
 * @author Xie Yin
 * @since 2021-08-28
 */

@Api(tags = "Metadata Management")
@RestController
@RequestMapping("/metaservice/table-details")
@CrossOrigin //跨域问题
public class TableDetailsController {

    @Autowired
    private TableDetailsService tableDetailsService;

    /**
     * @param current
     * @param limit
     * @param tableQuery
     * @return Json Object
     */
    @ApiOperation(value = "多条件组合查询fact表")
    @PostMapping("pageTableCondition/{current}/{limit}")
    public R pageTableCondition(@ApiParam(name = "current", value = "current page", required = true) @PathVariable long current,
                                @ApiParam(name = "limit", value = "page count", required = true) @PathVariable long limit,
                                @RequestBody(required = false) TableQuery tableQuery){

        //创建page对象
        Page<TableDetails> pageParam = new Page<>(current,limit);
        tableDetailsService.pageQuery(pageParam, tableQuery);
        // 得到总记录数和数据
        List<TableDetails> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("Total", total).data("rows", records);
    }


    @ApiOperation(value = "根据ID删除表")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable Integer id) {
        boolean flag = tableDetailsService.removeById(id);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

