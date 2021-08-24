package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionhandler.CustomException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Xie Yin
 * @since 2021-07-23
 */

@Api(tags = "讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
@CrossOrigin //跨域问题
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R listTeacher() {
        List<EduTeacher> list = eduTeacherService.list(null);

        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    // 分页查询
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@ApiParam(name = "current", value = "当前页码", required = true) @PathVariable Long current,
                             @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit){
        // 1.创建page对象
        Page<EduTeacher> pageObj = new Page<>(current,limit);
        eduTeacherService.page(pageObj, null);

//        try {
//            int i = 10 / 0; // 测试全局异常处理, 测试特定异常处理
//        }catch (Exception e){
//            // 执行自定义异常
//            throw new CustomException(20001, "Catch CustomException...");
//        }

        // 2.直接返回page对象
        return R.ok().data("result", pageObj);
/*      3. 自定义返回数据
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("Total", total).data("rows", records);
 */
    }


    // 条件查询带分页, @RequestBody需要和@PostMapping一起使用
    @ApiOperation(value = "多条件组合查询讲师")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@ApiParam(name = "current", value = "当前页码", required = true) @PathVariable long current,
                                  @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        // 创建page对象
        Page<EduTeacher> pageParam = new Page<>(current,limit);
        // 调用方法实现条件查询分页
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        // 得到总记录数和数据
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("Total", total).data("rows", records);
    }

    // 添加讲师, @RequestBody需要和@PostMapping一起使用
    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){

        boolean save = eduTeacherService.save(eduTeacher);
        return save ? R.ok(): R.error();

    }


    // 根据讲师id查询
    @ApiOperation(value = "根据讲师id查询")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("teacher", eduTeacher);
    }

    // 修改讲师
    @ApiOperation(value = "修改讲师")
    @PostMapping("modifyTeacher")
    public R modifyTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }
}

