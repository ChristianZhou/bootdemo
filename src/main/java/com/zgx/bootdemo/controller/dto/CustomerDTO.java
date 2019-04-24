package com.zgx.bootdemo.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhouguixing
 * @date 2019/4/17 17:07
 * @description 客户实体类 表：CUSTOMER
 */
@Data
public class CustomerDTO implements Serializable {
    private Long custCode;//主键、客户代码
    private String setSettlementMethodCode;//结算方式
    private String cusCustTypeCode;//客户类型
    private String custName;//客户名称
    private String mnemonicCode;//助记码
    private String tel;//电话
    private String fax;//传真号
    private String email;//邮箱
    private String address;//地址
    private String workUnitCode;//工作单位
    private String postcode;//邮编
    private String bankAccount;//银行账号
    private Integer tag;//启用标记
    @JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
    private java.sql.Date settlementDate;//结算日期
    private java.sql.Date birthday;//生日
    private java.sql.Date monthlySettlementDate;//月结日期
    private BankDTO bank;//银行
}
