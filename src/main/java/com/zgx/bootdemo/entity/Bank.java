package com.zgx.bootdemo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Native;

/**
 * @author dongyunqi
 * @date 2017年9月6日上午9:28:56
 * @description 银行实体类 表：BANK
 */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    @Id
    @GeneratedValue
    private Long bankCode;//主键、银行代码
    @Column
    private String bankName;//银行名称
    public Long getBankCode() {
        return bankCode;
    }
    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}
