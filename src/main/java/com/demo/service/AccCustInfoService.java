package com.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import com.demo.utils.*;

import com.demo.domain.AccCustInfo;
import com.demo.domain.AccCustInfoQuery;
import com.demo.dao.AccCustInfoMapper;

/**
 * 客户信息表
 * @author model-driven
 * @date 2020-11-25
 **/
@Service("accCustInfoService")
@Slf4j
public class AccCustInfoService {

    @Autowired
    private AccCustInfoMapper accCustInfoMapper;

    /**
     * 增加
     */
    public BasicResult addAccCustInfo(AccCustInfo accCustInfo) {
        log.info("request AccCustInfoService.addAccCustInfo param: {}",JSON.toJSONString(accCustInfo));
        if (accCustInfo == null) {
            return BasicResult.newFailBasicResult("参数为空");
        }
        accCustInfoMapper.insert(accCustInfo);
        return BasicResult.newSuccessBasicResult();
    }

    /**
     * 批量增加
     */
    public BasicResult addBatch(List<AccCustInfo> accCustInfoList){
        log.info("request AccCustInfoService.addBatch size: {}",accCustInfoList.size());
        if (accCustInfoList == null || accCustInfoList.isEmpty()) {
            return BasicResult.newFailBasicResult("参数为空");
        }
        accCustInfoMapper.insertBatch(accCustInfoList);
        return BasicResult.newSuccessBasicResult();
    }

    /**
     * 没有则增加有则修改
     */
    public BasicResult addOrUpdate(AccCustInfo accCustInfo) {
        log.info("request AccCustInfoService.addOrUpdate param:{}",JSON.toJSONString(accCustInfo));
        if (accCustInfo == null) {
            return BasicResult.newFailBasicResult("参数为空");
        }
        accCustInfoMapper.insertOrUpdate(accCustInfo);
        return BasicResult.newSuccessBasicResult();
    }

    /**
     * 删除
     */
    public BasicResult deleteById(long id){
        log.info("request AccCustInfoService.deleteBy param:{}",id);
        accCustInfoMapper.deleteById(id);
        return BasicResult.newSuccessBasicResult();
    }

    /**
     * 根据id修改
     */
    public BasicResult updateAccCustInfoById(AccCustInfo accCustInfo){
        log.info("request AccCustInfoService.modifyAccCustInfo param:{}",JSON.toJSONString(accCustInfo));
        accCustInfoMapper.update(accCustInfo);
        return BasicResult.newSuccessBasicResult();
    }

    /**
     * 批量修改
     */
    @Transactional
    public BasicResult updateBatch(List<AccCustInfo> accCustInfoList){
        log.info("request AccCustInfoService.modifyBatch size:" + accCustInfoList.size());
        BasicResult result = new BasicResult();
        int count = 0;
        for (AccCustInfo accCustInfo : accCustInfoList) {
            count += accCustInfoMapper.update(accCustInfo);
        }
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setMsg(String.valueOf(count));
        return result;
    }

    /**
     * 根据id查询
     */
    public AccCustInfo searchAccCustInfoById(Long id){
        return accCustInfoMapper.findById(id);
    }

    /**
     * 根据条件查询
     */
    public ListResult<AccCustInfo> searchAccCustInfo(Query<AccCustInfoQuery> query){
        log.info("request AccCustInfoService.searchAccCustInfo param:{}",JSON.toJSONString(query));
        ListResult<AccCustInfo> result = new ListResult<>();
        List<AccCustInfo> list = accCustInfoMapper.getAllList(query);
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValues(list);
        return result;
    }

    /**
     * 根据条件分页查询
     */
    public PageListResult<AccCustInfo> searchPageAccCustInfo(PageQuery<AccCustInfoQuery> pageQuery){
        log.info("request AccCustInfoService.searchPageAccCustInfo param:" + JSON.toJSONString(pageQuery));
        PageListResult<AccCustInfo> result = new PageListResult<AccCustInfo>();
        long count = accCustInfoMapper.getCount(pageQuery);
        PageQueryWrapper<AccCustInfoQuery> wrapper = new PageQueryWrapper<AccCustInfoQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<AccCustInfo> itemList = accCustInfoMapper.getPagenationList(wrapper);
        PageListResult<AccCustInfo> retValue = new PageListResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValues(itemList);
        long currentPage = pageQuery.getPageNo() > 1 ? pageQuery.getPageNo() : 1;
        Pagenation pagenation = new Pagenation(currentPage, count, pageQuery.getPageSize());
        result.setPagenation(pagenation);
        log.info("result AccCustInfoService.searchPageAccCustInfo 处理结果:{}",JSON.toJSONString(result));
        return result;
    }

    /**
     * 根据条件分页查询 必须传id 针对大表的分页查询
     */
    public ListResult<AccCustInfo> searchPageAccCustInfoById(IdPageQuery<AccCustInfoQuery> idPageQuery){
        log.info("request AccCustInfoService.searchPageAccCustInfoById param:" + JSON.toJSONString(idPageQuery));
        ListResult<AccCustInfo> result = new ListResult<>();
        List<AccCustInfo> itemList = accCustInfoMapper.getPagenationListById(idPageQuery);
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValues(itemList);
        return result;
    }

    /**
     * 根据条件查询总条数
     */
    public GenericResult<Long> getTotalCount(Query<AccCustInfoQuery> query) {
        log.info("request AccCustInfoService.getTotalCount param:{}",JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        long count = accCustInfoMapper.getTotalCount(query);
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        log.info("response AccCustInfoService.getTotalCount : {}",JSON.toJSONString(result));
        return result;
    }

    /**
     * 分页总条数
     */
    public GenericResult<Long> getCount(PageQuery<AccCustInfoQuery> pageQuery) {
        log.info("request AccCustInfoService.getCount param:{}" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        long count = accCustInfoMapper.getCount(pageQuery);
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        log.info("response AccCustInfoService.getCount 处理结果:{}",JSON.toJSONString(result));
        return result;
    }

}
