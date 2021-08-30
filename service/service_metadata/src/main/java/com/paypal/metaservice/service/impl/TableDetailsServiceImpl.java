package com.paypal.metaservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.paypal.metaservice.entity.TableDetails;
import com.paypal.metaservice.entity.lineage.TableQuery;
import com.paypal.metaservice.mapper.TableDetailsMapper;
import com.paypal.metaservice.service.TableDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * table details 服务实现类
 * </p>
 *
 * @author Xie Yin
 * @since 2021-08-28
 */
@Service
public class TableDetailsServiceImpl extends ServiceImpl<TableDetailsMapper, TableDetails> implements TableDetailsService {

    @Override
    public void pageQuery(Page<TableDetails> pageParam, TableQuery tableQuery) {
        //构建条件
        QueryWrapper<TableDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        if(tableQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        // 多条件组合查询, mybatis学过动态sql
        String database = tableQuery.getDb();
        String table = tableQuery.getName();
        String owner = tableQuery.getOwner();
        String begin = tableQuery.getBegin();
        String end = tableQuery.getEnd();

        // 判断条你简直否是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(database)){
            // 构建条件
            queryWrapper.like("db_name", database);
        }
        if(!StringUtils.isEmpty(table)){
            // 构建条件
            queryWrapper.like("table_name", table);
        }
        if(!StringUtils.isEmpty(owner)){
            // 构建条件
            queryWrapper.like("owner", owner);
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
