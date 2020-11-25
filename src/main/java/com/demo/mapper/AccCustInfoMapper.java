package com.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.demo.domain.AccCustInfo;
import com.demo.domain.AccCustInfoQuery;
import com.demo.utils.*;

/**
 * 客户信息表
 * @author model-driven
 * @date 2020-11-25
 **/
public interface AccCustInfoMapper {

    /**
     * 增加
     */
    int insert(AccCustInfo accCustInfo);

    /**
     * 批量增加
     */
    int insertBatch(List<AccCustInfo> accCustInfoList);

    /**
     * 无则增加有则修改
     */
    int insertOrUpdate(AccCustInfo accCustInfo);

    /**
     * 根据id删除
     */
    int deleteById(long id);

    /**
     * 根据id修改
     */
    int update(AccCustInfo accCustInfo);

    /**
     * 根据id查询
     */
    AccCustInfo findById(Long id);

    /**
     * 根据条件查询
     */
    List<AccCustInfo> getAllList(Query<AccCustInfoQuery> query);

    /**
     * 根据条件分页查询
     */
    List<AccCustInfo> getPagenationList(PageQuery<AccCustInfoQuery> pageQuery);

    /**
     * 按照最小id分页查询
     */
    List<AccCustInfo> getPagenationListById(IdPageQuery<AccCustInfoQuery> idPageQuery);

    /**
     * 分页查询条数
     */
    long getCount(PageQuery<AccCustInfoQuery> pageQuery);

    /**
     * 查询条数
     */
    long getTotalCount(Query<AccCustInfoQuery> query);

}
