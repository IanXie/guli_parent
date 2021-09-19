package com.paypal.metaservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.paypal.metaservice.entity.TableDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import com.paypal.metaservice.entity.lineage.TableQuery;

/**
 * <p>
 * table details 服务类
 * </p>
 *
 * @author Xie Yin
 * @since 2021-08-28
 */
public interface TableDetailsService extends IService<TableDetails> {

    void pageQuery(Page<TableDetails> pageParam, TableQuery tableQuery);

}
