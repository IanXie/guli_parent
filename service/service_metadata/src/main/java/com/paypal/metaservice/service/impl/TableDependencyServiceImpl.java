package com.paypal.metaservice.service.impl;

import com.paypal.metaservice.entity.TableDependency;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import com.paypal.metaservice.mapper.TableDependencyMapper;
import com.paypal.metaservice.service.TableDependencyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * table dependency 服务实现类
 * </p>
 *
 * @author Xie Yin
 * @since 2021-09-18
 */
@Service
public class TableDependencyServiceImpl extends ServiceImpl<TableDependencyMapper, TableDependency> implements TableDependencyService {

//    @Autowired
//    TableDependencyMapper tableDependencyMapper;


    @Override
    public List<TableDependency> getDependencyByName(LineageQuery lineageQuery) {

        return baseMapper.getDependencyByName(lineageQuery);
//        return tableDependencyMapper.getDependencyByName(lineageQuery);
    }
}
