package com.paypal.metaservice.service.impl;

import com.paypal.metaservice.entity.TableDependency;
import com.paypal.metaservice.entity.lineage.LineageQuery;
import com.paypal.metaservice.mapper.TableDependencyMapper;
import com.paypal.metaservice.service.TableDependencyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String, LinkedHashMap> getDependencyByName(LineageQuery lineageQuery) {

        // All children for a fact or ods table
        List<TableDependency> data = baseMapper.getDependencyByName(lineageQuery);
        // A list to sotre all the parent and children data with json format
        Map lineageMap = new HashMap();

        // Get the root node
        for (TableDependency entity : data) {
            LinkedHashMap map = new LinkedHashMap<>();
            if (entity.getPid() == 0){
                map.put("id", entity.getId());
                map.put("label", entity.getTableName());
                map.put("children", getChildren(data,entity.getId()));
                lineageMap.put("result", map);
            }
        }

        return lineageMap;
    }

//    @Override
//    public List<LinkedHashMap> getDependencyByName(LineageQuery lineageQuery) {
//
//        // All children for a fact or ods table
//        List<TableDependency> data = baseMapper.getDependencyByName(lineageQuery);
//        // A list to sotre all the parent and children data with json format
//        List<LinkedHashMap> lineageList = new ArrayList<>();
//
//        // Get the root node
//        for (TableDependency entity : data) {
//            LinkedHashMap map = new LinkedHashMap<>();
//            if (entity.getPid() == 0){
//                map.put("id", entity.getId());
//                map.put("label", entity.getTableName());
//                map.put("children", getChildren(data,entity.getId()));
//                lineageList.add(map);
//            }
//        }
//
//        return lineageList;
//    }


    /**
     * 递归处理：通过id获取子级，查询子级下的子级
     * @param data 数据库的原始数据
     * @param id 主id
     * @return 该id下得子级
     */
    public List<LinkedHashMap> getChildren(List<TableDependency> data, int id) {
        List<LinkedHashMap> list = new ArrayList();
        if (data == null || data.size() == 0) {
            return list;
        }
        for (TableDependency entity : data) {
            LinkedHashMap map = new LinkedHashMap();
            //如果本级id与数据的父id相同，就说明是子父级关系
            if (id == entity.getPid()) {
                map.put("id", entity.getId());
//                map.put("parentId", entity.getPid());
                map.put("label", entity.getTableName());
                //查询子级下的子级
                if(! getChildren(data, entity.getId()).isEmpty()){
                    map.put("children", getChildren(data, entity.getId()));
                }

//                map.put("children", getChildren(data, entity.getId()));
                list.add(map);
            }
        }
        return list;
    }




}
