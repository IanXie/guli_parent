package com.paypal.metaservice.mapper;

import com.paypal.metaservice.entity.TableDependency;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import java.util.List;
import javax.sound.sampled.Line;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * table dependency Mapper 接口
 * </p>
 *
 * @author Xie Yin
 * @since 2021-09-18
 */
@Mapper
public interface TableDependencyMapper extends BaseMapper<TableDependency> {

    List<TableDependency> getDependencyByName(LineageQuery lineageQuery);
}
