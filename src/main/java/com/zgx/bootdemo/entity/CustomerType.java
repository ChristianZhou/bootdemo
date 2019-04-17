package com.zgx.bootdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_type")
public class CustomerType {

  @Id
  private String custTypeCode;
  @Column
  private String custTypeName;


  public String getCustTypeCode() {
    return custTypeCode;
  }

  public void setCustTypeCode(String custTypeCode) {
    this.custTypeCode = custTypeCode;
  }


  public String getCustTypeName() {
    return custTypeName;
  }

  public void setCustTypeName(String custTypeName) {
    this.custTypeName = custTypeName;
  }

}
