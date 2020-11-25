package com.demo.domain;

import java.util.List;

import com.demo.utils.Query;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 客户信息表
 * @author model-driven
 * @date 2020-11-25
 **/
@Data
public class AccCustInfoQuery extends Query {

    static final long serialVersionUID = 1L;

    public AccCustInfoQuery() {}

    private AccCustInfoQuery(Builder builder) {
        
        this.id = builder.id;
        this.uuid = builder.uuid;
        this.custNo = builder.custNo;
        this.pin = builder.pin;
        this.profFlag = builder.profFlag;
        this.nationality = builder.nationality;
        this.version = builder.version;
        this.yn = builder.yn;
        this.createdTime = builder.createdTime;
        this.modifiedTime = builder.modifiedTime;
        this.bizDate = builder.bizDate;
    }

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
    
    public static class Builder {
    
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
    
        /**
         * 自动编号
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
        /**
         * 唯一标识:客户号_PIN
         */
        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }
    
        /**
         * 客户编号
         */
        public Builder custNo(String custNo) {
            this.custNo = custNo;
            return this;
        }
    
        /**
         * 用户pin
         */
        public Builder pin(String pin) {
            this.pin = pin;
            return this;
        }
    
        /**
         * 专业投资者标识 0-普通投资者 1-专业投资者
         */
        public Builder profFlag(Integer profFlag) {
            this.profFlag = profFlag;
            return this;
        }
    
        /**
         * 国籍代码 156-中国
         */
        public Builder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }
    
        /**
         * 版本号 yyyyMMddHHmmss
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }
    
        /**
         * 数据状态 0-无效 1-有效
         */
        public Builder yn(Integer yn) {
            this.yn = yn;
            return this;
        }
    
        /**
         * 创建时间
         */
        public Builder createdTime(Date createdTime) {
            this.createdTime = createdTime;
            return this;
        }
    
        /**
         * 最后修改时间
         */
        public Builder modifiedTime(Date modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }
    
        /**
         * 业务
         */
        public Builder bizDate(Date bizDate) {
            this.bizDate = bizDate;
            return this;
        }
    
        public AccCustInfoQuery build() {
            return new AccCustInfoQuery(this);
        }
    }

}
