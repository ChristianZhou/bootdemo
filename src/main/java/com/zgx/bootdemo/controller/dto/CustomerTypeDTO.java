package com.zgx.bootdemo.controller.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class CustomerTypeDTO implements Serializable {

  private Long custTypeCode;
  private String custTypeName;

}
