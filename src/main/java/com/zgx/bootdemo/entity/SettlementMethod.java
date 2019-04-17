package com.zgx.bootdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settlement_method")
public class SettlementMethod {

  @Id
  private String settlementMethodCode;
  @Column
  private String settlementTypeMethodName;


  public String getSettlementMethodCode() {
    return settlementMethodCode;
  }

  public void setSettlementMethodCode(String settlementMethodCode) {
    this.settlementMethodCode = settlementMethodCode;
  }


  public String getSettlementTypeMethodName() {
    return settlementTypeMethodName;
  }

  public void setSettlementTypeMethodName(String settlementTypeMethodName) {
    this.settlementTypeMethodName = settlementTypeMethodName;
  }

}
