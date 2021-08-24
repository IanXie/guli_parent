package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Xie Yin
 * @since 2021-07-23
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {


    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery) {
        // 构建条件
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        if(teacherQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        // 多条件组合查询, mybatis学过动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        // 判断条你简直否是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)){
            // 构建条件
            queryWrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level)){
            // 构建条件
            queryWrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(begin)){
            // 构建条件
            queryWrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            // 构建条件
            queryWrapper.le("gmt_create", end);
        }

        // 根据创建时间排序
        queryWrapper.orderByDesc("gmt_create");

        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
