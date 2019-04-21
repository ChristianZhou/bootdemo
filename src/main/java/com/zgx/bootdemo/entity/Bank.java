package com.zgx.bootdemo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author dongyunqi
 * @date 2017年9月6日上午9:28:56
 * @description 银行实体类 表：BANK
 */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {


  private static final long serialVersionUID = -1826205236201593454L;
  @Id
  private String bankCode;//主键、银行代码
  @Column
  private String bankName;//银行名称

  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

}
