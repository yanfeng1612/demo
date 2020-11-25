package com.demo.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import com.demo.utils.*;

import com.demo.domain.AccCustInfo;
import com.demo.domain.AccCustInfoQuery;
import com.demo.service.AccCustInfoService;

/**
 * 客户信息表
 * @author model-driven
 * @date 2020-11-25
 **/
@RestController
@RequestMapping(value = "/accCustInfo", produces = "application/json; charset=utf-8")
@Slf4j
public class AccCustInfoController {

    @Autowired
    private AccCustInfoService accCustInfoService;

    @RequestMapping(value = "/add")
    public Response<AccCustInfo> add(@RequestBody AccCustInfo accCustInfo) {
        Response<AccCustInfo> response = new Response<>();
        try {
            BasicResult result = accCustInfoService.addAccCustInfo(accCustInfo);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/deleteById")
    public Response<AccCustInfo> deleteById(Long id) {
        Response<AccCustInfo> response = new Response<>();
        try {
            BasicResult result = accCustInfoService.deleteById(id);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/updateById")
    public Response<AccCustInfo> updateById(@RequestBody AccCustInfo accCustInfo) {
        Response<AccCustInfo> response = new Response<>();
        try {
            BasicResult result = accCustInfoService.updateAccCustInfoById(accCustInfo);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/addOrUpdate")
    public Response<AccCustInfo> addOrUpdate(@RequestBody AccCustInfo accCustInfo) {
        Response<AccCustInfo> response = new Response<>();
        try {
            BasicResult result = accCustInfoService.addOrUpdate(accCustInfo);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    /**
     * 查询数据列表
     */
    @RequestMapping("/list")
    public Response<PageListResult> list(@RequestBody PageQuery<AccCustInfoQuery> query) {
        try {
            log.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<AccCustInfo> pageListResult = accCustInfoService.searchPageAccCustInfo(query);
            log.info("分页查询数据参数信息resp: {}-{}", pageListResult.getCode(), JSON.toJSONString(pageListResult.getPagenation()));
            APIMsgCode apiMsgCode = CodeConverter.convert(pageListResult.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, pageListResult);
        } catch (Exception e) {
            log.error("分页查询数据参数信息exception: ", e);
        }
        return ResponseTemplate.FAILURE.getResponse(null);
    }

    /**
     * 查询数据详情
     */
    @RequestMapping(value = "/detail", method = {RequestMethod.POST,RequestMethod.GET})
    public Response<AccCustInfo> getAccCustInfoById(Long id) {
        log.info("查询详情参数 {}",id) ;
        Response<AccCustInfo> response = new Response<>();
        try {
            AccCustInfo result = accCustInfoService.searchAccCustInfoById(id);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            log.error("查询数据异常:{}",id,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
