package com.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 客户信息表
 * @author model-driven
 * @date 2020-11-30
 **/
@Data
public class AccCustInfo implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 唯一标识:客户号_PIN
     */
    private String uuid;
    
    /**
     * 客户编号
     */
    private String custNo;
    
    /**
     * 用户pin
     */
    private String pin;
    
    /**
     * 专业投资者标识 0-普通投资者 1-专业投资者
     */
    private Integer profFlag;
    
    /**
     * 国籍代码 156-中国
     */
    private String nationality;
    
    /**
     * 版本号 yyyyMMddHHmmss
     */
    private String version;
    
    /**
     * 数据状态 0-无效 1-有效
     */
    private Integer yn;
    
    /**
     * 创建时间
     */
    private Date createdTime;
    
    /**
     * 最后修改时间
     */
    private Date modifiedTime;
    
    /**
     * 业务
     */
    private Date bizDate;
    
}
