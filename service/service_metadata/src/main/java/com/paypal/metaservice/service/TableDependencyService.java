package com.paypal.metaservice.service;

import com.paypal.metaservice.entity.TableDependency;
import com.baomidou.mybatisplus.extension.service.IService;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import java.util.List;

/**
 * <p>
 * table dependency 服务类
 * </p>
 *
 * @author Xie Yin
 * @since 2021-09-18
 */
public interface TableDependencyService extends IService<TableDependency> {

    List<TableDependency> getDependencyByName(LineageQuery lineageQuery);

}
