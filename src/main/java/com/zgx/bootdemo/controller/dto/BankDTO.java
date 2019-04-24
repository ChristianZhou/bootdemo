package com.zgx.bootdemo.controller.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dongyunqi
 * @date 2017年9月6日上午9:28:56
 * @description 银行实体类 表：BANK
 */
@Data
public class BankDTO implements Serializable {
    private Long bankCode;//主键、银行代码
    private String bankName;//银行名称

}
