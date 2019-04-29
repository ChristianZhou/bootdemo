package com.zgx.bootdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "customer_type")
public class CustomerType implements Serializable {

  @Id
  private Long custTypeCode;
  @Column
  private String custTypeName;

  public Long getCustTypeCode() {
    return custTypeCode;
  }

  public void setCustTypeCode(Long custTypeCode) {
    this.custTypeCode = custTypeCode;
  }

  public String getCustTypeName() {
    return custTypeName;
  }

  public void setCustTypeName(String custTypeName) {
    this.custTypeName = custTypeName;
  }

}
